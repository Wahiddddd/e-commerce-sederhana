package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.entity.Product;
import com.example.e_commerce_sederhana.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // SELLER add product
    @PostMapping
    public String create(@RequestParam Long sellerId,
                         @RequestBody Product product) {
        service.createProduct(sellerId, product);
        return "Product created";
    }
}
