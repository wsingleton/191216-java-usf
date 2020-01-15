package com.revature.project_0.models;

public class UserAccount {

    private int userId;
    private int accountId;

    public UserAccount(int userId, int accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }


}
