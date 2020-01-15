package com.revature.project_0.services;

import com.revature.project_0.models.UserAccount;
import com.revature.project_0.repos.UserAccountRepository;

public class UserAccountService {

    private UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository repo) {
        super();
        this.userAccountRepository = repo;
    }

    public void register(int userId, int accountId) {
        UserAccount userAccount = new UserAccount(userId, accountId);
        userAccountRepository.save(userAccount);
    }

}
