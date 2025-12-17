package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.entity.User;
import com.example.e_commerce_sederhana.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // CREATE USER
    @PostMapping
    public String createUser(@RequestBody User user) {
        Long id = service.createUser(user);
        return "User created with id = " + id;
    }

    // ADD ROLE
    @PostMapping("/{id}/roles")
    public String addRole(@PathVariable Long id,
                          @RequestParam String role) {
        service.addRole(id, role);
        return "Role added";
    }
}

