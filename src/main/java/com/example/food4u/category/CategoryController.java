package com.example.food4u.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public String listCategories(Model model){
        List<Category> list = repository.findAll();
        model.addAttribute("listCategories", list);
        return "categories";
    }

    @GetMapping("/new")
    public String showCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("/save")
    public String saveCategory(Category category){
        repository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model){
        Category category = repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        model.addAttribute("category", category);
        return "categoryForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
    repository.deleteById(id);
        return "redirect:/categories";
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public String handleCategoryNotFound(){
        return "redirect:/error";
    }
}
