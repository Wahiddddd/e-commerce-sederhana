package com.example.e_commerce_sederhana.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public boolean hasRole(Long userId, String role) {
        String sql = "SELECT COUNT(*) FROM user_roles WHERE user_id=? AND role=?";
        Integer count = jdbc.queryForObject(sql, Integer.class, userId, role);
        return count != null && count > 0;
    }
}

