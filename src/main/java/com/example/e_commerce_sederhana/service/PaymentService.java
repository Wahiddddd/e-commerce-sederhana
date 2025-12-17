package com.example.e_commerce_sederhana.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    private final JdbcTemplate jdbc;
    private final RoleService roleService;

    public PaymentService(JdbcTemplate jdbc, RoleService roleService) {
        this.jdbc = jdbc;
        this.roleService = roleService;
    }

    public void pay(Long buyerId, Long orderId) {

        roleService.validateRole(buyerId, "BUYER");

        Long owner = jdbc.queryForObject(
                "SELECT buyer_id FROM orders WHERE id = ?",
                Long.class,
                orderId
        );

        if (!buyerId.equals(owner))
            throw new RuntimeException("Order bukan milik buyer");

        BigDecimal total = jdbc.queryForObject(
                "SELECT total_price FROM orders WHERE id = ?",
                BigDecimal.class,
                orderId
        );

        jdbc.update("""
            INSERT INTO payments (order_id, amount, status)
            VALUES (?, ?, 'SUCCESS')
        """, orderId, total);

        jdbc.update("""
            UPDATE orders SET status = 'PAID' WHERE id = ?
        """, orderId);
    }
}


