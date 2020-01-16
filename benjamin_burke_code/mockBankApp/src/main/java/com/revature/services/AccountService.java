package com.revature.services;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.AccountUserRepository;

import static com.revature.AppDriver.app;

public class AccountService {
    private AccountRepository accRepo;
    private AccountUserRepository uaRepo;

    public AccountService(AccountRepository repo, AccountUserRepository uaRepo) {
        this.accRepo = repo;
        this.uaRepo = uaRepo;
    }

    public void registerAccount(Account account) {


        if (!isAccountValid(account)) throw new InvalidRequestException();
        accRepo.save(account);


    }

    public double deposit(double value) {
        if (value < 0) throw new InvalidRequestException();
        User currentUser = app().getCurrentSession().getSessionUser();
        Account currentAccount = uaRepo.getAccountByUser(currentUser);

        currentAccount.setBalance(currentAccount.getBalance() + value);

        accRepo.update(currentAccount);

        return currentAccount.getBalance();

    }

    public double withdraw(double value) {
        if (value < 0) throw new InvalidRequestException();
        User currentUser = app().getCurrentSession().getSessionUser();
        Account currentAccount = uaRepo.getAccountByUser(currentUser);

        if (currentAccount.getBalance() - value < 0) throw new InvalidRequestException();
        currentAccount.setBalance(currentAccount.getBalance() - value);

        accRepo.update(currentAccount);

        return currentAccount.getBalance();
    }

    public boolean isAccountValid(Account account) {
        return account.getAccountId() != null;
    }

}

