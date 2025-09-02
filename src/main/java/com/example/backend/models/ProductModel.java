package com.example.backend.models;

import com.example.backend.models.enums.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data

@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @NotBlank
    private String category;

}
;