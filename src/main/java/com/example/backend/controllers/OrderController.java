package com.example.backend.controllers;

import com.example.backend.services.OrderService;
import com.example.backend.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    public OrderService orderService;
    @RequestMapping("getAllOrders")
    public String getAllOrders() {
        return orderService.getAllOrders().toString();
    }
    @RequestMapping("addNewOrder")
    public String addNewOrder(OrderModel Order) {
        return orderService.addNewOrder(Order);
    }
    @RequestMapping("getOrderById/{id}")
    public OrderModel getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @RequestMapping("updateOrder/{id}")
    public OrderModel updateOrder(@PathVariable Long id, OrderModel updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }
    @RequestMapping("deleteOrder/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
