package com.example.backend.dto;

import java.util.List;

public record UserDTO(String username, List<String> role) {
}
