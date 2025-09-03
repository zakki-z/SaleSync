package com.example.backend.repository;

import com.example.backend.models.OrderModel;
import com.example.backend.models.users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    // Find orders by specific user ✅
    List<OrderModel> findByUser(UserModel user);

    // Find orders by user ID ✅
    List<OrderModel> findByUserId(Long userId);

    // Find orders by username ✅
    @Query("SELECT o FROM OrderModel o WHERE o.user.username = :username")
    List<OrderModel> findByUserUsername(@Param("username") String username);

    // Find orders by user role ✅
    @Query("SELECT o FROM OrderModel o WHERE o.user.role = :role")
    List<OrderModel> findByUserRole(@Param("role") String role);

    // Find orders by user and status ✅
    @Query("SELECT o FROM OrderModel o WHERE o.user.id = :userId AND o.status = :status")
    List<OrderModel> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);
}

