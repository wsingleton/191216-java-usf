package com.liberationbank.services;

import com.liberationbank.exceptions.AuthenticationException;
import com.liberationbank.models.Account;
import com.liberationbank.models.User;
import com.liberationbank.repos.AccountRepository;
import com.liberationbank.repos.UserAccountRepository;
import com.liberationbank.repos.UserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.liberationbank.AppDriver.*;

public class AccountService {
    private AccountRepository accountRepo;
    private UserAccountRepository userAccountRepo;

    public AccountService(){super();}

    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void createNewAccount(Account newObj){
     accountRepo.save(newObj);
     currentAccount = newObj;
     accountRepo.updateCompositeKey(currentAccount, currentUser);
    }

    public void retrieveUserAccount(User User) {

        currentAccount = accountRepo.getAccountByUserId(User.getId()).orElseThrow(() -> new AuthenticationException());


    }

    public boolean validateDeposit( double deposit){
        if(deposit < 0 || deposit >5000 ){ return false; }
        return true;
    }


    public boolean validateWithdrawalBalance( double withdrawal, double balance){
        if(withdrawal> balance || withdrawal <0){
            return false;
        }
        return true;
    }


    public double sanitizeValue(double money){
        //if(money < 0){return new String("cannot be negative value");}
        BigDecimal bd = new BigDecimal(money).setScale(2, RoundingMode.DOWN);
        double formatedMoney = bd.doubleValue();
        return formatedMoney;
    }
}
