package com.example.food4u.category;

import com.example.food4u.integrient.Ingredient;
import com.example.food4u.integrient.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public String listCategories(Model model){
        List<Category> list = categoryRepository.findAll();
        model.addAttribute("listCategories", list);
        return "categories";
    }

    @GetMapping("/new")
    public String showCategoryForm(Model model){
        List<Ingredient> ingredientsList = ingredientRepository.findAll();
        model.addAttribute("category", new Category());
        model.addAttribute("listIngredients", ingredientsList);
        return "categoryForm";
    }

    @PostMapping("/save")
    public String saveCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model){
        List<Ingredient> ingredientsList = ingredientRepository.findAll();
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        model.addAttribute("category", category);
        model.addAttribute("listIngredients", ingredientsList);
        return "categoryForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
    categoryRepository.deleteById(id);
        return "redirect:/categories";
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public String handleCategoryNotFound(){
        return "redirect:/error";
    }
}
