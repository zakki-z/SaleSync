package com.example.backend.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data

@Table(name = "users")
public class UserModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    @NotBlank
    @Size(min = 6, max = 50)
    private String password;
    @NotBlank
    private String role;
}
