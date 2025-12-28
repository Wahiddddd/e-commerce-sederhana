package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.config.security.JwtUtil;
import com.example.e_commerce_sederhana.entity.User;
import com.example.e_commerce_sederhana.service.AuthService;
import com.example.e_commerce_sederhana.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.example.e_commerce_sederhana.dto.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        User user = authService.authenticate(
                request.getEmail(),
                request.getPassword()
        );
        List<String> roles = authService.getRoles(user.getId());
        return JwtUtil.generateToken(user.getEmail(), roles);
    }
}


