package com.example.backend.services;

import com.example.backend.exceptions.InventoryNotFoundExpection;
import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.InventoryModel;
import com.example.backend.models.users.UserModel;
import com.example.backend.repository.InventoryRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<InventoryModel> getAllInventories() {
        return inventoryRepository.findAll();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STOCK_AGENT')")
    public InventoryModel getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundExpection("Inventory not found for ID: " + id));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STOCK_AGENT')")
    public List<InventoryModel> getInventoryByUserId(Long userId) {
        List<InventoryModel> inventory = inventoryRepository.findByUserId(userId);
        if (inventory.isEmpty()) {
            throw new UserNotFoundException("No inventory found for user ID: " + userId);
        }
        return inventory;
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STOCK_AGENT')")
    public InventoryModel createInventory(Long userId, InventoryModel inventory) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + userId));
        inventory.setUser(user);
        return inventoryRepository.save(inventory);
    }
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STOCK_AGENT')")
//    @Transactional
//    public InventoryModel updateInventory(long id,InventoryModel updatedInventory) {
//        InventoryModel existingInventory = inventoryRepository.findById(id)
//                .orElseThrow(() -> new InventoryNotFoundExpection("Inventory not found for ID: " + id));
//        existingInventory.setQuantity(updatedInventory.getQuantity());
//        existingInventory.setPricePerUnit(updatedInventory.getPricePerUnit());
//        existingInventory.setTotalAmount(updatedInventory.getTotalAmount());
//        existingInventory.setTotalPrice(updatedInventory.getTotalPrice());
//        existingInventory.setProduct(updatedInventory.getProduct());
//        existingInventory.setUser(updatedInventory.getUser());
//        return inventoryRepository.save(updatedInventory);
//    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STOCK_AGENT')")
    public void deleteInventory(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new InventoryNotFoundExpection("Inventory not found for ID: " + id);
        }
         inventoryRepository.deleteById(id);
    }
}
