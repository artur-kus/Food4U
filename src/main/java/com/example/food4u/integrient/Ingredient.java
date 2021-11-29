package com.example.food4u.integrient;

import com.example.food4u.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64, nullable = false, unique = true)
    private String name;
    @ManyToMany
    @JoinTable(
            name= "category_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> category;

    @Override
    public String toString() {
        return name;
    }
}
