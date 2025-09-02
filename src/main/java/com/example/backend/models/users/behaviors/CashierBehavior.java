package com.example.backend.models.users.behaviors;

import com.example.backend.models.users.UserModel;
import org.springframework.stereotype.Component;

@Component
public class CashierBehavior extends UserModel {
    @Override
    public String getRole() {
        return "CASHIER";
    }
}
