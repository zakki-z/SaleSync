package com.example.backend.controllers.users;

import com.example.backend.models.users.UserModel;
import com.example.backend.services.users.AuthService;
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
    public UserModel register(String username, String password, String role) {
        return authService.register(username, password, role);
    }
    @RequestMapping("/logout")
    public String logout() {
        return authService.logout();
    }
}
