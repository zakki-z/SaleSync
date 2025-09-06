package com.example.backend.dto;

import com.example.backend.models.enums.Status;
import jakarta.validation.constraints.NotNull;

public record OrderUpdateDTO(@NotNull Status status) {
}