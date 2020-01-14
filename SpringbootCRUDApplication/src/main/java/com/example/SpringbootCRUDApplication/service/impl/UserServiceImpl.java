package com.example.SpringbootCRUDApplication.service.impl;

import com.example.SpringbootCRUDApplication.entity.Account;
import com.example.SpringbootCRUDApplication.entity.User;
import com.example.SpringbootCRUDApplication.repository.AccountRepository;
import com.example.SpringbootCRUDApplication.repository.UserRepository;
import com.example.SpringbootCRUDApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired                // NO LONGER auto-created by Spring Cloud (see below)
    //@LoadBalanced     		// Explicitly request the load-balanced template
    // with Ribbon built-in
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public AccountRepository accountRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        Optional<User> one = userRepository.findById(Long.valueOf(userId));
        return one.get();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(String userId, User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        User user = new User();
        user.setId(Long.valueOf(userId));
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUsersAccountBalance() {
        List<User> userList = userRepository.findAll();
        User user1 = new User();
        if (userList != null && userList.size() > 0) {
            for (User user : userList) {
                List<Account> fromAccountList = user.getAccountList();
                if (fromAccountList != null && fromAccountList.size() > 0) {
                    for (Account accounts : fromAccountList) {
                        Account account = accountRepository.findByAccountNumberEquals(accounts.getAccountNumber());
                        account.setCurrentBalance(account.getCurrentBalance());
                        user1.setAccountList(Collections.singletonList(account));
                        userList.add(user1);
                    }
                }
            }
        }
        return userList;
    }
}
