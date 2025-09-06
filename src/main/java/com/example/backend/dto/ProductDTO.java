package com.example.backend.dto;

import com.example.backend.models.enums.ProductType;

public record ProductDTO(Long id, String name, ProductType type, String category) {
}