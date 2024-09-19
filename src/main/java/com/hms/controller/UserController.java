package com.hms.controller;

import com.hms.model.User;
import com.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // Field injection (not final)
    @Autowired
    private UserService userService;

    // Save a user (POST /users)
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Fetch all users (GET /users)
    @GetMapping
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    // Fetch a user by ID (GET /users/{id})
    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable("id") int userId) {
        return userService.fetchUserById(userId);
    }
}
