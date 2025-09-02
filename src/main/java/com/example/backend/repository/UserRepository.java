package com.example.backend.repository;

import com.example.backend.models.users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);

    Long id(Long id);
}