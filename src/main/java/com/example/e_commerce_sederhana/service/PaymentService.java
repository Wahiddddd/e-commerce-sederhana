package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.Order;
import com.example.e_commerce_sederhana.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final OrderRepository orderRepo;

    public PaymentService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void pay(Long buyerId, Long orderId) {
        Order order = orderRepo.findById(orderId);

        if (!order.getBuyerId().equals(buyerId)) {
            throw new RuntimeException("Unauthorized payment");
        }

        orderRepo.updateStatus(orderId, "PAID");
    }
}



