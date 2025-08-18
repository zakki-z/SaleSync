package com.example.backend.exceptions;

public class OrderNotFoundExpection extends RuntimeException {
    public OrderNotFoundExpection(String message) {
        super(message);
    }
}
