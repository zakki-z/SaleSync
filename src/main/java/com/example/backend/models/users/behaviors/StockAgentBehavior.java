package com.example.backend.models.users.behaviors;

import com.example.backend.models.users.UserModel;
import org.springframework.stereotype.Component;

@Component
public class StockAgentBehavior extends UserModel {
    @Override
    public String getRole() {
        return "STOCK_AGENT";
    }
}
