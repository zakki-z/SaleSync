package com.example.backend.repository;

import com.example.backend.models.OrderModel;
import com.example.backend.models.users.UserModel;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    // Find orders by user ID ✅
    List<OrderModel> findByUserId(Long userId);

    List<OrderModel> findByUserRole(@NotBlank String user_role);
}

