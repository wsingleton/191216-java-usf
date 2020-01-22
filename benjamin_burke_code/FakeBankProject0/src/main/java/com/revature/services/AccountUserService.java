package com.revature.services;

import com.revature.repos.AccountUserRepository;
import com.revature.models.AccountUser;
import com.revature.repos.CrudRepository;

public class AccountUserService {

    private AccountUserRepository accountUserRepository;

    public  AccountUserService(AccountUserRepository repo) {
        super();
        this.accountUserRepository = repo;
    }

    public void register(int userId, int accountId) {
        AccountUser accountUser = new AccountUser(userId, accountId);
        accountUserRepository.save(accountUser);
    }

}
