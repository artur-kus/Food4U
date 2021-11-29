package com.example.food4u.product;

import com.example.food4u.category.Category;
import com.example.food4u.order.PlacedOrder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64, nullable = false)
    private String name;
    @Column(length = 256, nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(length = 8, nullable = false)
    private Double price;
//    @ManyToMany
//    @JoinTable(
//            name = "order_product",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<PlacedOrder> placedOrder;

    public Product(Long id, String name, String description, Category category, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category.getName() +
                ", ingredients=" + category.getIngredient() +
                ", price=" + price +
                '}';
    }
}
