package com.example.food4u.category;

import com.example.food4u.integrient.Ingredient;

import javax.persistence.*;

@Entity
public class RelationWithIngredients {

    @EmbeddedId
    RelationWithIngredientsKey id;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    Category category;
}
