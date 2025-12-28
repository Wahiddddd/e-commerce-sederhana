package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Long createOrder(Long buyerId) {
        return orderRepo.create(buyerId);
    }
}






