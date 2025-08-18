package com.example.backend.exceptions;

public class InventoryNotFoundExpection extends RuntimeException {
    public InventoryNotFoundExpection(String message) {
        super(message);
    }
}
