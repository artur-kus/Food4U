package com.example.food4u.home;

import com.example.food4u.category.Category;
import com.example.food4u.product.Product;
import com.example.food4u.product.ProductRepository;
import com.example.food4u.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("basket")
public class BasketItemController {

    private final BasketItemRepository basketRepository;
    private final ProductService productService;

    @GetMapping
    public String basketList(Model model) {
        List<BasketItem> basketList = basketRepository.findAll();
        model.addAttribute("basketList", basketList);
        return "showBasketList";
    }

    @GetMapping("/add/{productId}")
    public String showBasketForm(@PathVariable("productId") Long productId, Model model) {
        Product chooseProduct = productService.findProductById(productId);
        model.addAttribute("basket", new BasketItem());
        model.addAttribute("productId", productId);
        model.addAttribute("chooseProduct", chooseProduct);
        return "basketItemForm";
    }

    @PostMapping("/save")
    public String saveBasketItem(BasketItem basket) {
        basketRepository.save(basket);
        return "redirect:/menu";
    }

    @GetMapping("/clear")
    public String clearBasket(){
        basketRepository.deleteAll();
        return "redirect:/basket";
    }
}
