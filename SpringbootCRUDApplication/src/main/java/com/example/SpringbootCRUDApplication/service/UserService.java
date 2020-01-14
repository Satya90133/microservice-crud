package com.example.SpringbootCRUDApplication.service;


import com.example.SpringbootCRUDApplication.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(String userId);

    void addUser(User user);

    void updateUser(String userId, User user);

    void deleteUser(String userId);

    List<User> getAllUsersAccountBalance();
}
