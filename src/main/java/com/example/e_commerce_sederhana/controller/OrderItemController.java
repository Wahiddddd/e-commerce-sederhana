package com.example.e_commerce_sederhana.controller;

import com.example.e_commerce_sederhana.dto.AddItemRequest;
import com.example.e_commerce_sederhana.entity.OrderItem;
import com.example.e_commerce_sederhana.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @GetMapping("/{orderId}/items")
    public List<OrderItem> getItems(@PathVariable Long orderId) {
        return service.findByOrderId(orderId);
    }

    @PostMapping("/{orderId}/items")
    public String addItem(@PathVariable Long orderId,
                          @RequestBody AddItemRequest req) {

        service.addItem(orderId, req.getProductId(), req.getQuantity());
        return "Item added";
    }
}

