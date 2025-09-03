package com.example.backend.services.users.behaviors;

import com.example.backend.models.users.UserModel;
import org.springframework.stereotype.Component;

@Component
public class StockAgentBehavior extends UserBehavior {
    @Override
    public String getRole() {
        return "STOCK_AGENT";
    }
}
