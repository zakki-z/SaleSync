package com.example.backend.services.users;

import com.example.backend.exceptions.InvalidUserCredentials;
import com.example.backend.exceptions.UserExistsException;
import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.models.users.UserModel;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public UserModel register(String username, String password, String role) {
        if(userRepository.findByUsername(username) != null) {
            throw new UserExistsException("User already exists");
        }
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }
    public String login(String username, String password) {
        UserModel existingUser = userRepository.findByUsername(username);
        if (existingUser.getUsername() == null) {
            throw new UserNotFoundException("User not found");
        }
        else if (!existingUser.getUsername().matches(username) || !existingUser.getPassword().matches(password)) {
            throw new InvalidUserCredentials("Invalid Username or Password");
        }
        else {
            return "Login Successful";
        }
    }
    public String logout() {
        return "Logout Successful";
    }
}