package com.revature.project0.services;

import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Accounts;
import com.revature.project0.models.User;
import com.revature.project0.repos.AccountRepository;
import com.revature.project0.repos.UserRepository;

import static com.revature.project0.AppDriver.currentUser;

public class AccountService {


    private AccountRepository accRepo;


    public  AccountService(){

    }

    public AccountService(AccountRepository accRepo) {
        this.accRepo = accRepo;
    }

    public void register(Accounts newAcc, int id) {


        if (!isValid(newAcc)) throw new InvalidRequestException();

        AccountRepository acc = new AccountRepository();
        acc.saveAccount(newAcc,id);

    }


    public boolean isValid(Accounts acc) {
        if (acc == null) {

            return false;
        }
        if (acc.getAccountType() == null || acc.getAccountType().trim().equals("")) {

            return false;
        }
        return true;
    }
}
