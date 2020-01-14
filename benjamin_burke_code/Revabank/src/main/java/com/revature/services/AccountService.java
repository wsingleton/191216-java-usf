package com.revature.services;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repos.AccountRepository;

public class AccountService {

    private AccountRepository accRepo;

    public AccountService(){

    }

    public AccountService(AccountRepository accRepo){
        this.accRepo = accRepo;
    }

    public void register(Account newAcc, int id){
        if (!isValid(newAcc)) throw new InvalidRequestException();
        AccountRepository acc = new AccountRepository();
        acc.save2(newAcc, id);
    }

    public boolean isValid(Account acc){
        if (acc == null){
            return false;
        } if(acc.getAccountType() == null || acc.getAccountType().trim().equals("")){
            return false;
        }
        return true;
    }
}
