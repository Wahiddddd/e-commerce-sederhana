package com.example.e_commerce_sederhana.repository;

import com.example.e_commerce_sederhana.entity.OrderItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepository {

    private final JdbcTemplate jdbc;

    public OrderItemRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(OrderItem item) {
        String sql = """
            INSERT INTO order_items(order_id, product_id, quantity, subtotal)
            VALUES (?, ?, ?, ?)
        """;
        jdbc.update(sql,
                item.getOrderId(),
                item.getProductId(),
                item.getQuantity(),
                item.getSubtotal()
        );
    }

    public List<OrderItem> findByOrderId(Long orderId) {
        String sql = "SELECT * FROM order_items WHERE order_id = ?";
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



