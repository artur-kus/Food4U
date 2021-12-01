package com.example.food4u.home;

import com.example.food4u.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketItemService {

    private final BasketItemRepository basketRepository;


    public Double calculateBasketSum() {
        return basketRepository.findAll().stream()
                .map((basketItem)-> basketItem.getProduct().getPrice() * basketItem.getAmount())
                .reduce((double) 0, Double::sum);
    }

    public List<BasketItem> basketListWithoutRepeats(List<BasketItem> basketList){
        return basketList;
    }
}
