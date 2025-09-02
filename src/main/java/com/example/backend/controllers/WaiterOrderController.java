package com.example.backend.controllers;

import com.example.backend.models.OrderModel;
import com.example.backend.services.WaiterOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waiterOrders")
@CrossOrigin(origins = "http://localhost:3000")
public class WaiterOrderController {
    @Autowired
    private WaiterOrderService waiterOrderService;
    @GetMapping("/getAllInventories")
    public List<OrderModel> getAllInventories() {
        return waiterOrderService.getAllOrdersByWaiter();
    }
    @PostMapping("/saveOrder")
    public OrderModel saveOrder(OrderModel Order) {
        return waiterOrderService.saveOrder(Order);
    }
}
