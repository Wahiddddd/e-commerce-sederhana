package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/pay")
    public String pay(@RequestParam Long buyerId,
                      @RequestParam Long orderId) {
        service.pay(buyerId, orderId);
        return "Payment success";
    }
}

