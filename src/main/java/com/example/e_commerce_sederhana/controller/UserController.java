package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.repository.UserRepository;
import com.example.e_commerce_sederhana.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepo;

    public UserController(UserService userService, UserRepository userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    // ADMIN ONLY
    @PostMapping("/{userId}/roles")
    public String addRole(@PathVariable Long userId,
                          @RequestParam String role) {
        userService.addRole(userId, role);
        return "Role added";
    }
}


