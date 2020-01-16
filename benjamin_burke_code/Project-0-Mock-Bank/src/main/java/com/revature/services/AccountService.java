package com.revature.services;

import com.revature.exceptcions.InvalidRequestException;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import jdk.nashorn.internal.ir.CallNode;

import static com.revature.AppDriver.*;

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
