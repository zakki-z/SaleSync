package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter

@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pricePerUnit;
    private LocalDateTime date;
    private LocalDateTime time;
    private enum status{
        PENDING,
        COMPLETED,
        CANCELLED
    };
    private String totalAmount;
    private String totalPrice;
    @JoinColumn(name = "user_id")
    private String userId;
    @JoinColumn(name = "product_id")
    private String productId;
    @JoinColumn(name = "product_name")
    private String productName;
}
