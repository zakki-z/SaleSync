package com.example.backend.models.users.behaviors;

import com.example.backend.models.users.UserModel;

public class WaiterBehavior extends UserModel {
    @Override
    public String getRole() {
        return "WAITER";
    }
}
