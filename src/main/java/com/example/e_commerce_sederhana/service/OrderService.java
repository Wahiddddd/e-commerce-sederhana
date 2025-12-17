package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.Order;
import com.example.e_commerce_sederhana.repository.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class OrderService {

    private final JdbcTemplate jdbc;
    private final RoleService roleService;

    public OrderService(JdbcTemplate jdbc, RoleService roleService) {
        this.jdbc = jdbc;
        this.roleService = roleService;
    }

    public Long createOrder(Long buyerId) {
        roleService.validateRole(buyerId, "BUYER");

        jdbc.update("""
            INSERT INTO orders (buyer_id, status, total_price)
            VALUES (?, 'PENDING', 0)
        """, buyerId);

        return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }
}





