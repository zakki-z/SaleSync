package com.example.backend.models;

import com.example.backend.models.enums.InventoryType;
import com.example.backend.models.users.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data


@Table(name = "inventory")
public class InventoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(0)
    private int quantity;
    @Min(0)
    private double pricePerUnit;
    @NotNull
    private LocalDateTime entryDate;
    private LocalDateTime releaseDate;
    private LocalDateTime expiryDate;
    private String usedBy;

    @Enumerated(EnumType.STRING)
    private InventoryType type;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;
}
;
