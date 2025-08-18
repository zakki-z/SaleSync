package com.example.backend.repository;

import com.example.backend.models.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <InventoryModel, Long>{
}
