package com.example.food4u.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Embeddable
public class RelationWithIngredientsKey implements Serializable {

    @Column(name = "ingredient_id")
    Long ingredientId;

    @Column(name = "category_id")
    Long categoryId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

}
