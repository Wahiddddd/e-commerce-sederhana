package com.example.e_commerce_sederhana.repository;

import com.example.e_commerce_sederhana.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbc;

    public OrderRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Long create(Long buyerId) {
        String sql = """
            INSERT INTO orders(buyer_id, status, total_price)
            VALUES (?, 'PENDING', 0)
        """;
        jdbc.update(sql, buyerId);

        return jdbc.queryForObject(
                "SELECT LAST_INSERT_ID()", Long.class
        );
    }

    public Order findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            Order o = new Order();
            o.setId(rs.getLong("id"));
            o.setBuyerId(rs.getLong("buyer_id"));
            o.setStatus(rs.getString("status"));
            o.setTotalPrice(rs.getBigDecimal("total_price"));
            return o;
        }, id);
    }

    public void updateTotal(Long orderId, BigDecimal total) {
        jdbc.update(
                "UPDATE orders SET total_price = ? WHERE id = ?",
                total, orderId
        );
    }

    public void updateStatus(Long orderId, String status) {
        jdbc.update(
                "UPDATE orders SET status = ? WHERE id = ?",
                status, orderId
        );
    }
}

