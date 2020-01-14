package com.example.SpringbootCRUDApplication.controller;

import com.example.SpringbootCRUDApplication.entity.Account;
import com.example.SpringbootCRUDApplication.entity.User;
import com.example.SpringbootCRUDApplication.service.AccountService;
import com.example.SpringbootCRUDApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAccountController {

    @Autowired
    public AccountService accountService;

    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public List<Account> create(@RequestBody Account account) {
        accountService.save(account);
        return accountService.findAll();
    }

    @GetMapping
    public List<User> getAllUsersAccountBalance() {
        return userService.getAllUsersAccountBalance();
    }
}
