package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final JdbcTemplate jdbc;
    private final RoleService roleService;

    public ProductService(JdbcTemplate jdbc, RoleService roleService) {
        this.jdbc = jdbc;
        this.roleService = roleService;
    }

    // ✅ METHOD YANG DICARI CONTROLLER
    public void createProduct(Long sellerId, Product product) {

        // 🔒 validasi role
        roleService.validateRole(sellerId, "SELLER");

        String sql = """
            INSERT INTO products (name, price, stock, seller_id)
            VALUES (?, ?, ?, ?)
        """;

        jdbc.update(
                sql,
                product.getName(),
                product.getPrice(),
                product.getStock(),
                sellerId
        );
    }
}



