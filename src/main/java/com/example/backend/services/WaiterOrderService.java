package com.example.backend.services;

import com.example.backend.models.OrderModel;
import com.example.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class WaiterOrderService {
    @Autowired
    private OrderRepository OrderRepository;

    @PreAuthorize("hasRole('ROLE_WAITER')")
    public List<OrderModel> getAllOrdersByWaiter() {
        return OrderRepository.findAll();
    }
    @PreAuthorize("hasRole('ROLE_WAITER')")
    public OrderModel saveOrder(OrderModel Order) {
        OrderModel savedOrder = OrderRepository.save(Order);
        savedOrder.setCreatedAt(LocalDateTime.now());
        double totalAmount = savedOrder.getPricePerUnit() * savedOrder.getQuantity();
        savedOrder.setTotalPrice(totalAmount);
        return savedOrder;
    }
}