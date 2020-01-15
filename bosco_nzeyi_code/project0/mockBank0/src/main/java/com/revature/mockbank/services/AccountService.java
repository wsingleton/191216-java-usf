package com.revature.mockbank.services;

import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.models.Account;
import com.revature.mockbank.repositories.AccountRepo;
import  static com.revature.mockbank.repositories.AccountRepo.*;
import static com.revature.mockbank.AppDriver.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;


public class AccountService {

   private AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public AccountService() {
        super();
    }


    // method to create account
    public void createAccount(Account data){
        accountRepo.save(data);

        currentAccount = AccountRepo.newAccount;
    }


    // method to deposit
    public void deposit(int accountId, int userId, double amount){
        accountRepo.deposit(accountId, userId, amount);
    }


//
//    // method to withdraw
    public void withdraw(int accountId, int userId, double amount){
        accountRepo.withdraw(accountId, userId, amount);
    }

    // activity log
    public void activityHistory (int userId){
       accountRepo.activityLog(userId);
       activityLog = activities;
    }

    // method to validate and format amount deposited or withdrawn
    public Double validatedAmount (Double amount){
        if(amount.isNaN() || amount < 0) return 0.0;
//            throw new InvalidRequestException(
//        Double validAmount = null;
        try{
                // limit decimal points to 2.
                BigDecimal toTwoDecimal = BigDecimal.valueOf(amount);
                amount = toTwoDecimal.setScale(2, RoundingMode.DOWN).doubleValue();
//                validAmount = amount;
        } catch (Exception e){
            throw new InvalidRequestException();
        }
        return amount;
    }


}
