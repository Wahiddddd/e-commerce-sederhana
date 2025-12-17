package com.example.e_commerce_sederhana.repository;

import com.example.e_commerce_sederhana.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbc;

    public OrderRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Long create(Long buyerId) {
        jdbc.update("INSERT INTO orders(buyer_id,status,total) VALUES (?,?,0)",
                buyerId, "PENDING");
        return jdbc.queryForObject("SELECT MAX(id) FROM orders", Long.class);
    }

    public Order findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id=?";
        return jdbc.queryForObject(sql, (rs,n)->{
            Order o = new Order();
            o.setId(rs.getLong("id"));
            o.setBuyerId(rs.getLong("buyer_id"));
            o.setStatus(rs.getString("status"));
            o.setTotalPrice(rs.getBigDecimal("total_price"));
            return o;
        }, id);
    }

    public void updateTotal(Long id, double total) {
        jdbc.update("UPDATE orders SET total=? WHERE id=?", total, id);
    }

    public void updateStatus(Long id, String status) {
        jdbc.update("UPDATE orders SET status=? WHERE id=?", status, id);
    }
}

