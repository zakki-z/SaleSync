package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data


@Table(name = "inventory")
public class InventoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;
    private double totalAmount;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;



}
