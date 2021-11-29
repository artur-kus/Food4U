package com.example.food4u.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById(Long id){
       return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Product> findAllProducts(){
       return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
    productRepository.deleteById(id);
    }
}
