package com.example.backend.services;

import com.example.backend.exceptions.OrderNotFoundExpection;
import com.example.backend.models.OrderModel;
import com.example.backend.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository OrderRepository;
    
    public OrderModel getOrderById(Long id) {
        return OrderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundExpection("Order not found for ID: " + id));
    }
    public List<OrderModel> getAllOrders() {
        return OrderRepository.findAll();
    }
    public String addNewOrder(OrderModel Order) {
        OrderRepository.save(Order);
        return OrderRepository.findAll().toString();
    }
    public OrderModel saveOrder(OrderModel Order) {
        OrderModel savedOrder = OrderRepository.save(Order);
        savedOrder.setCreatedAt(LocalDateTime.now());
        double totalAmount = savedOrder.getPricePerUnit() * savedOrder.getQuantity();
        savedOrder.setTotalPrice(totalAmount);
        return savedOrder;
    }
    @Transactional
    public OrderModel updateOrder(Long id, OrderModel updatedOrder) {
        OrderModel existingOrder = OrderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundExpection("Order not found for ID: " + id));
        existingOrder.setPricePerUnit(updatedOrder.getPricePerUnit());
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setCreatedAt(updatedOrder.getCreatedAt());
        existingOrder.setProduct(updatedOrder.getProduct());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setUser(updatedOrder.getUser());
        return OrderRepository.save(existingOrder);
    }
    public void deleteOrder(Long id) {
        OrderRepository.deleteById(id);
    }
}
