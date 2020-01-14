package com.example.SpringbootCRUDApplication.service.impl;

import com.example.SpringbootCRUDApplication.entity.Account;
import com.example.SpringbootCRUDApplication.repository.AccountRepository;
import com.example.SpringbootCRUDApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    public AccountRepository accountRepository;

    public Account save(Account account) {
        accountRepository.save(account);
        return accountRepository.findByAccountNumberEquals(account.getAccountNumber());
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findByAccountNumber(String accountNumber) {
        return  accountRepository.findByAccountNumberEquals(accountNumber);
    }
}















