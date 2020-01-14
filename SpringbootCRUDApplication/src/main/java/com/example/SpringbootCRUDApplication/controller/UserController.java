package com.example.SpringbootCRUDApplication.controller;

import com.example.SpringbootCRUDApplication.entity.User;
import com.example.SpringbootCRUDApplication.service.UserService;
import com.example.SpringbootCRUDApplication.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

@Autowired
public UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUsers(@PathVariable String userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
