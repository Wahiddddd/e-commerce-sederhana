package com.example.e_commerce_sederhana.dto;

import lombok.Data;

@Data
public class AddItemRequest {
    private Long productId;
    private Integer quantity;
}
