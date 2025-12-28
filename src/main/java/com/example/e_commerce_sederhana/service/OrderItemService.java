package com.example.e_commerce_sederhana.service;

import com.example.e_commerce_sederhana.entity.OrderItem;
import com.example.e_commerce_sederhana.entity.Product;
import com.example.e_commerce_sederhana.repository.OrderItemRepository;
import com.example.e_commerce_sederhana.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository itemRepo;
    private final ProductRepository productRepo;

    public OrderItemService(OrderItemRepository itemRepo, ProductRepository productRepo) {
        this.itemRepo = itemRepo;
        this.productRepo = productRepo;
    }

    public void addItem(Long orderId, Long productId, int qty) {
        Product product = productRepo.findById(productId);

        if (product.getStock() < qty) {
            throw new RuntimeException("Stock not enough");
        }

        BigDecimal subtotal = product.getPrice()
                .multiply(BigDecimal.valueOf(qty));

        OrderItem item = new OrderItem();
        item.setOrderId(orderId);
        item.setProductId(productId);
        item.setQuantity(qty);
        item.setSubtotal(subtotal);

        itemRepo.save(item);

        productRepo.updateStock(productId, product.getStock() - qty);
    }

    public List<OrderItem> findByOrderId(Long orderId) {
        return itemRepo.findByOrderId(orderId);
    }
}






