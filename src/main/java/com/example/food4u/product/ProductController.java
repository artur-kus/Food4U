package com.example.food4u.product;

import com.example.food4u.category.Category;
import com.example.food4u.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @GetMapping("")
    public String listProducts(Model model) {
        List<Product> productList = productService.findAllProducts();
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
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model){
        List<Category> categoryList = categoryRepository.findAll();
        Product product = productService.findProductById(id);
        model.addAttribute("listCategories", categoryList);
        model.addAttribute("product", product);
        return "productForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
       productService.deleteProductById(id);
        return "redirect:/products";
    }
}
