package com.example.food4u.home;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class BasketItemForm {
    private Long productId;
    @Min(1)
    @Max(99)
    private int amount;
}
