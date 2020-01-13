package com.revature.project_0.services;

import com.revature.project_0.repos.AccountRepository;

public class AccountService {

    private AccountRepository accRepo;

    public AccountService(AccountRepository repo) {
        this.accRepo = repo;
    }

}
