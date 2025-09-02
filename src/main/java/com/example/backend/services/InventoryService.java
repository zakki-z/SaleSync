package com.example.backend.services;

import com.example.backend.exceptions.InventoryNotFoundExpection;
import com.example.backend.models.InventoryModel;
import com.example.backend.models.ProductModel;
import com.example.backend.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    public List<InventoryModel> getAllInventories() {
        return inventoryRepository.findAll();
    }
    public InventoryModel getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundExpection("Inventory not found for ID: " + id));
    }
    public String addNewInventory(InventoryModel inventory) {
        inventoryRepository.save(inventory);
        return inventoryRepository.findAll().toString();
    }
    @Transactional
    public InventoryModel updateInventory(long id,InventoryModel updatedInventory) {
        InventoryModel existingInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundExpection("Inventory not found for ID: " + id));
        existingInventory.setQuantity(updatedInventory.getQuantity());
        existingInventory.setPricePerUnit(updatedInventory.getPricePerUnit());
        existingInventory.setTotalAmount(updatedInventory.getTotalAmount());
        existingInventory.setTotalPrice(updatedInventory.getTotalPrice());
        existingInventory.setProduct(updatedInventory.getProduct());
        existingInventory.setUser(updatedInventory.getUser());
        return inventoryRepository.save(updatedInventory);
    }
    public void deleteInventory() {
         inventoryRepository.findAll();
         inventoryRepository.deleteAll();
    }
}
