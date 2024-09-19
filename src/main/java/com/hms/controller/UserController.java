package com.hms.controller;

import com.hms.model.User;
import com.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

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

    // Update a user (PUT /users/{id})
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int userId, @RequestBody User userDetails) {
        User existingUser = userService.fetchUserById(userId);

        if (existingUser == null) {
            // You can throw an exception or handle the case where the user does not exist
            throw new RuntimeException("User not found with ID: " + userId);
        }

        // Update user details
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setPassword(userDetails.getPassword());
        existingUser.setFullName(userDetails.getFullName());
        existingUser.setPhone(userDetails.getPhone());
        existingUser.setAge(userDetails.getAge());
        existingUser.setSex(userDetails.getSex());
        existingUser.setAddress(userDetails.getAddress());
        existingUser.setUserType(userDetails.getUserType());

        // Save and return the updated user
        return userService.saveUser(existingUser);
    }

    // Delete a user (DELETE /users/{id})
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int userId) {
        userService.deleteUserById(userId);
        return "User with ID " + userId + " has been deleted successfully.";
    }

}
