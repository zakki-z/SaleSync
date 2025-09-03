package com.example.backend.services;

import com.example.backend.exceptions.OrderNotFoundExpection;
import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.OrderModel;
import com.example.backend.models.users.UserModel;
import com.example.backend.repository.OrderRepository;
import com.example.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    
    public OrderModel getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundExpection("Order not found for ID: " + id));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }
    @PreAuthorize("hasAnyRole('ROLE_WAITER','ROLE_CASHEIR','ROLE_ADMIN')")
    public List<OrderModel> getAllOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
    @PreAuthorize("hasRole('ROLE_WAITER')")
    public OrderModel createOrder(Long userId, OrderModel order) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + userId));
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());
        double totalAmount = order.getPricePerUnit() * order.getQuantity();
        order.setTotalPrice(totalAmount);
        return orderRepository.save(order);
    }
    @PreAuthorize("hasAnyRole('ROLE_CASHEIR','ROLE_ADMIN')")
    @Transactional
    public OrderModel updateOrder(Long id, OrderModel updatedOrder) {
        OrderModel existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundExpection("Order not found for ID: " + id));
        existingOrder.setPricePerUnit(updatedOrder.getPricePerUnit());
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setCreatedAt(updatedOrder.getCreatedAt());
        existingOrder.setProduct(updatedOrder.getProduct());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setUser(updatedOrder.getUser());
        return orderRepository.save(existingOrder);
    }
    @PreAuthorize("hasAnyRole('ROLE_CASHEIR','ROLE_ADMIN')")
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
