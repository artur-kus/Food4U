package com.example.food4u.order;

import com.example.food4u.product.Product;
import com.example.food4u.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("")
    public String listOrders(Model model) {
        List<PlacedOrder> orderList = orderRepository.findAll();
        model.addAttribute("orderList", orderList);
        return "order";
    }

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("order", new PlacedOrder());
        model.addAttribute("productList", productList);
        return "orderForm";
    }

    @PostMapping("/save")
    public String saveOrder(Product product) {
        productRepository.save(product);
        return "redirect:/summary";
    }

    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable("id") Long id, Model model){
        List<Product> productList = productRepository.findAll();
        PlacedOrder placedOrder = orderRepository.findById(id).get();
        model.addAttribute("productList", productList);
        model.addAttribute("order", placedOrder);
        return "productForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderRepository.deleteById(id);
        return "redirect:/orders";
    }
}
