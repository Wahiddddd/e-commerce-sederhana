package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.User;
import com.example.e_commerce_sederhana.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;


@Service
public class UserService {

    private final UserRepository userRepo;
    private final JdbcTemplate jdbc;

    public UserService(UserRepository userRepo, JdbcTemplate jdbc) {
        this.userRepo = userRepo;
        this.jdbc = jdbc;
    }

    public void validateRole(Long userId, String role) {
        boolean hasRole = userRepo.hasRole(userId, role);
        if (!hasRole) {
            throw new IllegalArgumentException("User tidak memiliki role: " + role);
        }
    }

    public Long createUser(User user) {
        String sql = "INSERT INTO users(name,email) VALUES (?,?)";
        jdbc.update(sql, user.getName(), user.getEmail());

        return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    public void addRole(Long userId, String role) {
        String sql = "INSERT INTO user_roles(user_id, role) VALUES (?,?)";
        jdbc.update(sql, userId, role);
    }

    public boolean hasRole(Long userId, String role) {
        return userRepo.hasRole(userId, role);
    }
}


