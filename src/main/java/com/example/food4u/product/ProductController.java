package com.example.food4u.product;

import com.example.food4u.category.Category;
import com.example.food4u.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public String listProducts(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("listProducts", productList);
        return "products";
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", categoryList);
        return "productForm";
    }

    @PostMapping("/save")
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model){
        List<Category> categoryList = categoryRepository.findAll();
        Product product = productRepository.findById(id).get();
        model.addAttribute("listCategories", categoryList);
        model.addAttribute("product", product);
        return "productForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
