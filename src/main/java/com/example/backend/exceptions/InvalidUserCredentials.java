package com.example.backend.exceptions;

public class InvalidUserCredentials extends RuntimeException {
    public InvalidUserCredentials(String message) {
        super(message);
    }
}
