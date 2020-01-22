package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.AccountUserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.revature.AppDriver.*;

public class AccountService {
//    private AccountRepository accRepo;
//    private AccountUserRepository uaRepo;
//
//    public AccountService(){
//        super();
//    }
//
//    public AccountService(AccountRepository repo) {
//        this.accRepo = repo;
//
//    }
//
//    public void registerAccount(Account newObj) {
//        accRepo.save(newObj);
//        currentAccount = newObj;
//        accountRepo.updateCompositeKey(currentAccount, currentUser);
//
////        if (!isAccountValid(account)) throw new InvalidRequestException();
////        accRepo.save(account);
//
//
//    }
//
//    public double deposit(double value) {
//        if (value < 0) throw new InvalidRequestException();
//        User currentUser = app().getCurrentSession().getSessionUser();
//        Account currentAccount = uaRepo.getAccountByUser(currentUser);
//
//        currentAccount.setBalance(currentAccount.getBalance() + value);
//
//        accRepo.update(currentAccount);
//
//        return currentAccount.getBalance();
//
//    }
//
//    public double withdraw(double value) {
//        if (value < 0) throw new InvalidRequestException();
//        User currentUser = app().getCurrentSession().getSessionUser();
//        Account currentAccount = uaRepo.getAccountByUser(currentUser);
//
//        if (currentAccount.getBalance() - value < 0) throw new InvalidRequestException();
//        currentAccount.setBalance(currentAccount.getBalance() - value);
//
//        accRepo.update(currentAccount);
//
//        return currentAccount.getBalance();
//    }
//
//    public boolean isAccountValid(Account account) {
//        return account.getAccountId() != null;
//    }
//

    private AccountRepository accountRepo;
    private AccountUserRepository accoutUser;

    public AccountService(){super();}

    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void registerNewAccount(Account newObj){
        accountRepo.save(newObj);
        cuurentAccount = newObj;
        accountRepo.updateCompositeKey(cuurentAccount, currentUser);
    }

    public void retrieveUserAccount(User User) {

        cuurentAccount = accountRepo.getAccountByUserId(User.getUserId()).orElseThrow(() -> new AuthenticationException());


    }

    public boolean depositCheck( double deposit){
        if(deposit < 0 || deposit >10000 ){ return false; }
        return true;
    }


    public boolean withdrawBalanceCheck( double withdrawal, double balance){
        if(withdrawal> balance || withdrawal <0){
            return false;
        }
        return true;
    }


//    public double sanitizeValue(double money){
//        //if(money < 0){return new String("cannot be negative value");}
//        BigDecimal bd = new BigDecimal(money).setScale(2, RoundingMode.DOWN);
//        double formatedMoney = bd.doubleValue();
//        return formatedMoney;
//    }
}

