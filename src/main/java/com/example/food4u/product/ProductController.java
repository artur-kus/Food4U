package com.example.food4u.product;

import com.example.food4u.category.Category;
import com.example.food4u.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("listProducts", productList);
        return "products";
    }

    @GetMapping("products/new")
    public String showProductForm(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", categoryList);
        return "productForm";
    }

    @PostMapping("products/save")
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }
}
