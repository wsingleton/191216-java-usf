package com.revature.services;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.repositories.AccountRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static com.revature.MockBankDriver.currentUser;
import static com.revature.MockBankDriver.router;

public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void registerAccount(Integer userID){
        AccountRepository ar = new AccountRepository();
        Random rand = new Random();
        int num = 0;
        Integer savingsAccountNo = rand.nextInt(1000000);
        Account savingsAccount = new Account(savingsAccountNo,userID,0.0, AccountType.SAVINGS);
        if(!ar.save(savingsAccount)){
            System.out.println("Savings account not created!");
        }
        Integer checkingAccountNo = rand.nextInt(1000000);
        Account checkingAccount = new Account(checkingAccountNo,userID,0.0, AccountType.CHECKING);
        if(!ar.save(checkingAccount)){
            System.out.println("Checking account not created!");
        }
    }

    public Set<Account> getAccAmount(Integer id){
        AccountRepository ar = new AccountRepository();
        Set<Account> ac = ar.findById(id);
        return ac;
    }

    public void withdrawal(Account account,Double amount){
        AccountRepository ar = new AccountRepository();
        if(amount < 0.01){
            System.out.println("Enter a positive number!");
            router.navigate("/account");
        }else if(account.getAccAmount() - amount < 0){
            System.out.println("You cannot overdraw your account!");
            router.navigate("/account");
        }
        ar.update(account, -amount);
    }

    public void deposit(Account account, Double amount){
        AccountRepository ar = new AccountRepository();
        if(amount < 0.01){
            System.out.println("Enter a positive number!");
            router.navigate("/account");
        }
        ar.update(account, amount);
    }

    public Boolean makePayment(Account account, Double amount){
        AccountRepository ar = new AccountRepository();
        if(amount < 0.01){
            System.out.println("Enter a positive number!");
            router.navigate("/account");
        }else if(account.getAccAmount() - amount < 0){
            System.out.println("You should pay more than you owe!");
            router.navigate("/account");
        }
        if(ar.update(account, -amount)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean createAccount(Account account, Double loanAmount){
        Random rand = new Random();
        account.setAccountAmount(loanAmount);
        account.setAccountNo(rand.nextInt(1000000));
        account.setId(currentUser.getID());

        if(accountRepository.save(account)){
            return true;
        }else {
            return false;
        }
    }


}
