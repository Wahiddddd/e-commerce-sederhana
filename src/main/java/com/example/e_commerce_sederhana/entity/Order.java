package com.example.e_commerce_sederhana.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Order {
    private Long id;
    private Long buyerId;
    private String status;      // PENDING, PAID, CANCELED
    private BigDecimal totalPrice;
}










