package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.Product;
import com.example.e_commerce_sederhana.repository.ProductRepository;
import com.example.e_commerce_sederhana.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final RoleRepository roleRepo;

    public ProductService(ProductRepository productRepo, RoleRepository roleRepo) {
        this.productRepo = productRepo;
        this.roleRepo = roleRepo;
    }

    public void createProduct(Long sellerId, Product product) {
        if (!roleRepo.findRolesByUserId(sellerId).contains("ROLE_SELLER")) {
            throw new RuntimeException("Access denied");
        }

        product.setSellerId(sellerId);
        productRepo.save(product);
    }
}




