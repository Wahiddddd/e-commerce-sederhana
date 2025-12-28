package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.config.security.SecurityUtil;
import com.example.e_commerce_sederhana.repository.UserRepository;
import com.example.e_commerce_sederhana.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final UserRepository userRepo;

    public OrderController(OrderService service, UserRepository userRepo) {
        this.service = service;
        this.userRepo = userRepo;
    }

    @PostMapping
    public Long createOrder() {
        String email = SecurityUtil.getCurrentUserEmail();
        Long buyerId = userRepo.findByEmail(email).getId();

        return service.createOrder(buyerId);
    }
}


