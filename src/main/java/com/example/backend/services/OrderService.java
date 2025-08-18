package com.example.backend.services;

import com.example.backend.exceptions.OrderNotFoundExpection;
import com.example.backend.models.OrderModel;
import com.example.backend.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Transactional
    public OrderModel updateOrder(Long id, OrderModel updatedOrder) {
        OrderModel existingOrder = OrderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundExpection("Order not found for ID: " + id));
        existingOrder.setPricePerUnit(updatedOrder.getPricePerUnit());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setTime(updatedOrder.getTime());
        existingOrder.setDate(updatedOrder.getDate());
        existingOrder.setProductName(updatedOrder.getProductName());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
        return OrderRepository.save(existingOrder);
    }
    public void deleteOrder(Long id) {
        OrderRepository.deleteById(id);
    }
}
