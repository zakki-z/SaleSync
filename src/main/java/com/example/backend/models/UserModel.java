package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter

@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private enum role{
        ADMIN,
        CASHIER,
        STOCK_AGENT
    };
    @Enumerated(EnumType.STRING)
    private role role;
}
