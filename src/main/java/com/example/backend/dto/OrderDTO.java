package com.example.backend.dto;

public record OrderDTO(String username, String productName, int quantity, double price, String status) {
}
