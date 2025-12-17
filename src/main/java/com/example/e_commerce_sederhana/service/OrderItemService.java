package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.*;
import com.example.e_commerce_sederhana.repository.OrderItemRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemService {

    private final JdbcTemplate jdbc;

    public OrderItemService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional
    public void addItem(Long orderId, Long productId, int quantity) {

        // 1️⃣ ambil stock
        Integer stock = jdbc.queryForObject(
                "SELECT stock FROM products WHERE id=?",
                Integer.class, productId
        );

        if (stock == null || stock < quantity) {
            throw new IllegalArgumentException("Stock tidak cukup");
        }

        // 2️⃣ ambil harga
        BigDecimal price = jdbc.queryForObject(
                "SELECT price FROM products WHERE id=?",
                BigDecimal.class, productId
        );

        // 3️⃣ hitung subtotal
        BigDecimal subtotal = price.multiply(BigDecimal.valueOf(quantity));

        // 4️⃣ insert order item
        String sql = """
            INSERT INTO order_items(order_id, product_id, quantity, subtotal)
            VALUES (?,?,?,?)
        """;

        jdbc.update(sql, orderId, productId, quantity, subtotal);

        // 5️⃣ update stock
        jdbc.update(
                "UPDATE products SET stock = stock - ? WHERE id=?",
                quantity, productId
        );
    }

    public List<OrderItem> findByOrderId(Long orderId) {

        String sql = """
            SELECT id, order_id, product_id, quantity, subtotal
            FROM order_items
            WHERE order_id = ?
        """;

        return jdbc.query(sql, (rs, rowNum) -> {
            OrderItem item = new OrderItem();
            item.setId(rs.getLong("id"));
            item.setOrderId(rs.getLong("order_id"));
            item.setProductId(rs.getLong("product_id"));
            item.setQuantity(rs.getInt("quantity"));
            item.setSubtotal(rs.getBigDecimal("subtotal"));
            return item;
        }, orderId);
    }
}





