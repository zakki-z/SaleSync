package com.example.backend.controllers;

import com.example.backend.services.OrderService;
import com.example.backend.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    public OrderService orderService;
    @GetMapping
    public List<OrderModel> getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/waiters")
    public List<OrderModel> getAllWaitersOrders() {
        return orderService.getAllWaitersOrdersOrders();
    }
    @GetMapping("/user/{userId}")
    public List<OrderModel> getAllOrdersByUser(@PathVariable Long userId) {
        return orderService.getAllOrdersByUser(userId);
    }
    @PostMapping
    public String createOrder(Long userId, OrderModel Order) {
        return orderService.createOrder(userId, Order).toString();
    }
    @GetMapping("/{id}")
    public OrderModel getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @PutMapping("/{id}")
    public OrderModel updateOrder(@PathVariable Long id, OrderModel updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
