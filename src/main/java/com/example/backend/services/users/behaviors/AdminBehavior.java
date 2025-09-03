package com.example.backend.services.users.behaviors;

import org.springframework.stereotype.Component;

@Component
public class AdminBehavior extends UserBehavior {
    @Override
    public String getRole() {
        return "ADMIN";
    }
}
