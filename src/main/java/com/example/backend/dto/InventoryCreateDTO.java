package com.example.backend.dto;

import com.example.backend.models.enums.InventoryType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record InventoryCreateDTO(
        @Min(0) int quantity,
        @Min(0) double pricePerUnit,
        @NotNull LocalDateTime entryDate,
        LocalDateTime releaseDate,
        LocalDateTime expiryDate,
        String usedBy,
        InventoryType type,
        @NotNull Long productId,
        @NotNull Long userId
) {}