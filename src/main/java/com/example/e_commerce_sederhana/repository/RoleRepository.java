package com.example.e_commerce_sederhana.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    private final JdbcTemplate jdbc;

    public RoleRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addRole(Long userId, String role) {
        String sql = """
            INSERT INTO user_roles(user_id, role)
            VALUES (?, ?)
        """;
        jdbc.update(sql, userId, role);
    }

    public List<String> findRolesByUserId(Long userId) {
        String sql = "SELECT role FROM user_roles WHERE user_id = ?";
        return jdbc.queryForList(sql, String.class, userId);
    }
}

