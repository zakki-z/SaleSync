package com.example.backend.controllers;

import com.example.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    @Autowired
    private AuthService authService;
    @RequestMapping("/login")
    public String login(String username, String password) {
        return authService.login(username, password);
    }
    @RequestMapping("/register")
    public String register(String username, String password) {
        return authService.register(username, password);
    }
    @RequestMapping("/logout")
    public String logout() {
        return authService.logout();
    }
}
