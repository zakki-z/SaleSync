package com.example.backend.controllers;

import com.example.backend.models.InventoryModel;
import com.example.backend.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/getAllInventories")
    public String getAllInventories() {
        return inventoryService.getAllInventories().toString();
    }
    @GetMapping("/getInventoryById/{id}")
    public String getInventoryById(Long id) {
        return inventoryService.getInventoryById(id).toString();
    }
    @PostMapping("/addNewInventory")
    public String addNewInventory(@RequestBody InventoryModel inventory) {
        return inventoryService.addNewInventory(inventory);
    }
//    @PutMapping("/updateInventory/{id}")
//    public String updateInventory(Long id) {
//        return inventoryService.updateInventory(id, null).toString();
//    }
    @DeleteMapping("/deleteInventory")
    public void deleteInventory() {
        inventoryService.deleteInventory();
    }

}
