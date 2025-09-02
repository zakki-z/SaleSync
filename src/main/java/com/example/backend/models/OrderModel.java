package com.example.backend.models;

import com.example.backend.models.enums.Status;
import com.example.backend.models.users.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Data

@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(0)
    private double quantity;
    @Min(0)
    private double pricePerUnit;
    @NotNull
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Min(0)
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductModel product;

}
;