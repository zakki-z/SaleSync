package com.example.backend.services.users.behaviors;

import com.example.backend.models.users.UserModel;
import org.springframework.stereotype.Component;

@Component
public class CashierBehavior extends UserBehavior {
    @Override
    public String getRole() {
        return "CASHIER";
    }
}
