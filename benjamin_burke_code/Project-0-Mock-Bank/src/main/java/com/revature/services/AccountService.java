package com.revature.services;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.User;
import com.revature.repos.AccountRepository;

public class AccountService {

    private AccountRepository accRepo;
    private AccountUserService auRepo;

    public AccountService(AccountRepository accRepo, AccountUserService auRepo){
        this.accRepo=accRepo;
        this.auRepo=auRepo;
    }




    public double Deposit()(double amount){
        if(amount <0) throw new InvalidRequestException();
        User user =
        Account account = auRepo.

        account.
    }


}
