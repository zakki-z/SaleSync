package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data

@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double pricePerUnit;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double totalAmount;
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductModel product;

}
enum Status{
    PENDING,
    COMPLETED,
    CANCELLED
};