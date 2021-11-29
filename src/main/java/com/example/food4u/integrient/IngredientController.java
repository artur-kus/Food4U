package com.example.food4u.integrient;

import com.example.food4u.category.Category;
import com.example.food4u.category.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public String listIngredients(Model model) {
        List<Ingredient> list = ingredientRepository.findAll();
        model.addAttribute("listIngredients", list);
        return "ingredients";
    }

    @GetMapping("/new")
    public String showIngredientForm(Model model) {
        model.addAttribute("ingredient", new Category());
        return "ingredientForm";
    }

    @PostMapping("/save")
    public String saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id") Long id, Model model) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(IngredientNotFoundException::new);
        model.addAttribute("ingredient", ingredient);
        return "ingredientForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        ingredientRepository.deleteById(id);
        return "redirect:/ingredients";
    }

    @ExceptionHandler(IngredientNotFoundException.class)
    public String handleCategoryNotFound() {
        return "redirect:/error";
    }
}
