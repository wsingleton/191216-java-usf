package com.revature.project_0.services;

import com.revature.project_0.exceptions.InvalidRequestException;
import com.revature.project_0.models.Account;
import com.revature.project_0.models.AccountType;
import com.revature.project_0.repos.AccountRepository;

import static com.revature.project_0.AppDriver.app;

public class AccountService {

    private AccountRepository accRepo;

    public AccountService(AccountRepository repo) {
        this.accRepo = repo;
    }

    public void registerAccount(Account account) {


        if(!isAccountValid(account)) throw new InvalidRequestException();
        accRepo.save(account);



    }

    public void deposit(double value) {

    }

    public void withdraw(double value) {

    }

    public boolean isAccountValid(Account account) {
        return account.getAccountType() != null;
    }

}
