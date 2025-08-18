package com.example.backend.controllers;

import com.example.backend.services.OrderService;
import com.example.backend.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    public OrderService orderService;
    @GetMapping("getAllOrders")
    public String getAllOrders() {
        return orderService.getAllOrders().toString();
    }
    @PostMapping("addNewOrder")
    public String addNewOrder(OrderModel Order) {
        return orderService.addNewOrder(Order);
    }
    @GetMapping("getOrderById/{id}")
    public OrderModel getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @PutMapping("updateOrder/{id}")
    public OrderModel updateOrder(@PathVariable Long id, OrderModel updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }
    @DeleteMapping("deleteOrder/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
