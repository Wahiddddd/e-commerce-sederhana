package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.User;
import com.example.e_commerce_sederhana.repository.RoleRepository;
import com.example.e_commerce_sederhana.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public User authenticate(String email, String rawPassword) {
        User user = userRepo.findByEmail(email);

        if (!encoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }

    public List<String> getRoles(Long userId) {
        return roleRepo.findRolesByUserId(userId);
    }
}


