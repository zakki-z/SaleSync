package com.example.backend.controllers.users;

import com.example.backend.models.users.UserModel;
import com.example.backend.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    public UserService userService;
    @GetMapping("getAllUsers")
    public String getAllUsers() {
        return userService.getAllUsers().toString();
    }
    @GetMapping("getUserById/{id}")
    public UserModel getUserById(Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("addNewUser")
    public UserModel addNewUser(UserModel user) {
        return userService.addNewUser(user);
    }
    @PutMapping("updateUser/{id}")
    public UserModel updateUser(@PathVariable Long id, UserModel updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
