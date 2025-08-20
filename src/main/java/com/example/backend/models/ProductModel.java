package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String items;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    private String pricePerUnit;
    private String totalPrice;

}
     enum ProductType{
        raw_material,
        finished_good
    };