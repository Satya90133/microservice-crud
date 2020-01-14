package com.example.SpringbootCRUDApplication.service;

import com.example.SpringbootCRUDApplication.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();
    Account save(Account account);
}
