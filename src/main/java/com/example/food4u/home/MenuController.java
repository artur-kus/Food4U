package com.example.food4u.home;

import com.example.food4u.order.PlacedOrder;
import com.example.food4u.product.Product;
import com.example.food4u.product.ProductController;
import com.example.food4u.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public String viewMenuPage(Model model){
        List<Product> productList = productRepository.findAll(sortByCategory());
        model.addAttribute("productList", productList);
        return "menu";
    }

    public Sort sortByCategory(){
        return Sort.by(Sort.Direction.ASC, "category");
    }
}
