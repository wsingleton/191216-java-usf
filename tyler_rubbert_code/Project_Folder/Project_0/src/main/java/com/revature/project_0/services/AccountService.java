package com.revature.project_0.services;

import com.revature.project_0.exceptions.InvalidRequestException;
import com.revature.project_0.models.Account;
import com.revature.project_0.models.AccountType;
import com.revature.project_0.models.User;
import com.revature.project_0.repos.AccountRepository;
import com.revature.project_0.repos.UserAccountRepository;

import static com.revature.project_0.AppDriver.app;

public class AccountService {

    private AccountRepository accRepo;
    private UserAccountRepository uaRepo;

    public AccountService(AccountRepository repo, UserAccountRepository uaRepo) {
        this.accRepo = repo;
        this.uaRepo = uaRepo;
    }

    public void registerAccount(Account account) {


        if(!isAccountValid(account)) throw new InvalidRequestException();
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
        return account.getAccountType() != null;
    }

}
