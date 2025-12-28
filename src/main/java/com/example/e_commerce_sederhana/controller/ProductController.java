package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.config.security.SecurityUtil;
import com.example.e_commerce_sederhana.entity.Product;
import com.example.e_commerce_sederhana.repository.UserRepository;
import com.example.e_commerce_sederhana.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final UserRepository userRepo;

    public ProductController(ProductService service, UserRepository userRepo) {
        this.service = service;
        this.userRepo = userRepo;
    }

    @PostMapping
    public String create(@RequestBody Product product) {
        String email = SecurityUtil.getCurrentUserEmail();
        Long sellerId = userRepo.findByEmail(email).getId();

        service.createProduct(sellerId, product);
        return "Product created";
    }
}

