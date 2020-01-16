package com.revature.services;

import com.revature.AppDriver;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Account;
import com.revature.models.AccountUser;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.AccountUserRepository;

import static com.revature.AppDriver.app;

public class AccountService {

    private UserService userService;
    private AccountRepository accRepo;
    private AccountUserRepository auRepo;

    public AccountService(AccountRepository accRepo, AccountUserRepository auRepo) {
        this.accRepo = accRepo;
        this.auRepo = auRepo;
    }

    public void registerAccount(Account acc){

        if(!isAccountValid(acc)) throw new InvalidRequestException();

        if(accRepo.findById(acc.getAccountId()).isPresent()){

        }
        accRepo.save(acc);
        //hmmmm
//        currentUser = acc;
    }

    public double deposit(double deposit){
        if (deposit<0) throw new InvalidRequestException();
        User currentUser = app().getCurrentSession().getSessionUser();
        Account currentAccount = auRepo.getAccountUser(currentUser);

        currentAccount.setBalance(currentAccount.getBalance() + deposit);

        accRepo.update(currentAccount);
        return currentAccount.getBalance();


    }

    public boolean isAccountValid(Account account) {
        if(account == null) return false;

        if(account.getAccountId()==null || account.getAccountId().equals("")) return false;
        if(account.getBalance()==null || account.getBalance().equals("")) return false;

        return true;
    }
}
