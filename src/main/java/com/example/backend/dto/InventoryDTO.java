package com.example.backend.dto;

import com.example.backend.models.enums.InventoryType;
import java.time.LocalDateTime;

public record InventoryDTO(
        Long id,
        int quantity,
        double pricePerUnit,
        LocalDateTime entryDate,
        LocalDateTime releaseDate,
        LocalDateTime expiryDate,
        String usedBy,
        InventoryType type,
        String productName,
        String username
) {}