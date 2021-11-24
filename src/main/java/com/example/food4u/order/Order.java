//package com.example.food4u.order;
//
//import com.example.food4u.category.Category;
//import com.example.food4u.product.Product;
//import com.example.food4u.product.ProductController;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(length = 4, nullable = false)
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinTable(name = "product",
//            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_list_2_null"))
//    private List<Order> productList;
//    private int amount;
//    @Column(nullable = false)
//    private final Date currentUtilDate = new Date();
//
//
//}
