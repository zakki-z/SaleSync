package com.example.backend.models.users.behaviors;

import com.example.backend.models.users.UserModel;
import org.springframework.stereotype.Component;

@Component
public class AdminBehavior extends UserModel {
    @Override
    public String getRole() {
        return "ADMIN";
    }
}
