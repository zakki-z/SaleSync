package com.example.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderCreateDTO(
        @Min(0) double quantity,
        @Min(0) double pricePerUnit,
        @NotNull Long userId,
        @NotNull Long productId
) {}
