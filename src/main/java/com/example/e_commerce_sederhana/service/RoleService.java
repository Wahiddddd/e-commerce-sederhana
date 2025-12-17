package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final UserRepository userRepository;

    public RoleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateRole(Long userId, String role) {
        boolean valid = userRepository.hasRole(userId, role);
        if (!valid) {
            throw new IllegalArgumentException(
                    "User ID " + userId + " tidak memiliki role " + role);
        }
    }
}