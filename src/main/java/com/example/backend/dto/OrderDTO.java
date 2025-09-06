package com.example.backend.dto;

import com.example.backend.models.enums.Status;
import java.time.LocalDateTime;

public record OrderDTO(
        Long id,
        String username,
        String productName,
        double quantity,
        double pricePerUnit,
        double totalPrice,
        LocalDateTime createdAt,
        Status status
) {}