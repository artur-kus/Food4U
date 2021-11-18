package com.example.food4u.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Category> list = repository.findAll();
        model.addAttribute("listCategories", list);
        return "categories";
    }

    @GetMapping("categories/new")
    public String showCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("categories/save")
    public String saveCategory(Category category){
        repository.save(category);
        return "redirect:/categories";
    }
}
