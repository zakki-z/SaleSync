package com.example.backend.controllers;

import com.example.backend.models.InventoryModel;
import com.example.backend.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping
    public List<InventoryModel> getAllInventories() {
        return inventoryService.getAllInventories();
    }
    @GetMapping("/{id}")
    public InventoryModel getInventoryById(Long id) {
        return inventoryService.getInventoryById(id);
    }
    @GetMapping("/user/{userId}")
    public List<InventoryModel> getInventoryByUserId(Long userId) {
        return inventoryService.getInventoryByUserId(userId);
    }
    @PostMapping
    public InventoryModel createInventory(Long userId, @RequestBody InventoryModel inventory) {
        return inventoryService.createInventory(userId,inventory);
    }
//    @PutMapping("/updateInventory/{id}")
//    public String updateInventory(Long id) {
//        return inventoryService.updateInventory(id, null).toString();
//    }
    @DeleteMapping("/deleteInventory")
    public void deleteInventory(Long id) {
        inventoryService.deleteInventory(id);
    }

}
