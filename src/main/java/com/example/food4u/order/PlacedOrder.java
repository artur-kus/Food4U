package com.example.food4u.order;
import com.example.food4u.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlacedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Product> product;

    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private final Date currentUtilDate = new Date();
}
