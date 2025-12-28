package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.config.security.SecurityUtil;
import com.example.e_commerce_sederhana.repository.UserRepository;
import com.example.e_commerce_sederhana.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;
    private final UserRepository userRepo;

    public PaymentController(PaymentService service, UserRepository userRepo) {
        this.service = service;
        this.userRepo = userRepo;
    }

    @PostMapping("/pay/{orderId}")
    public String pay(@PathVariable Long orderId) {
        String email = SecurityUtil.getCurrentUserEmail();
        Long buyerId = userRepo.findByEmail(email).getId();

        service.pay(buyerId, orderId);
        return "Payment success";
    }
}

