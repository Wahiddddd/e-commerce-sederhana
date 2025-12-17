package com.example.e_commerce_sederhana.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepository {

    private final JdbcTemplate jdbc;

    public OrderItemRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(Long orderId, Long productId, int qty, double price) {
        String sql = """
            INSERT INTO order_items(order_id, product_id, qty, price)
            VALUES (?,?,?,?)
        """;
        jdbc.update(sql, orderId, productId, qty, price);
    }
}

