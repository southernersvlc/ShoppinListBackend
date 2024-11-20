package com.example.ShoppingListBackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")

public class ProductController {
    private ProductRepository productRepository = null;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return this.productRepository.findAll();
    }
/*
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
    //Optional<Product> productOptional = this.productRepository.findByName((product.getName());
        Product savedProduct = productRepository.save(product);


        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }*/

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

}
