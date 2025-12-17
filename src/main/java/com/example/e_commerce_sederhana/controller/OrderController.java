package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Long create(@RequestParam Long buyerId) {
        return service.createOrder(buyerId);
    }
}


