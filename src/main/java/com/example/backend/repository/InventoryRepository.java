package com.example.backend.repository;

import com.example.backend.models.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;;

public interface InventoryRepository extends JpaRepository <InventoryModel, Long>{
    List<InventoryModel> findByUserId(Long userId);

}
