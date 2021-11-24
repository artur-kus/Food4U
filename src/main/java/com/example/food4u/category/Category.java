package com.example.food4u.category;

import com.example.food4u.integrient.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64, nullable = false, unique = true)
    private String name;
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Ingredient> ingredient = new ArrayList<>();

    public Category(Long id) {
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }
}
