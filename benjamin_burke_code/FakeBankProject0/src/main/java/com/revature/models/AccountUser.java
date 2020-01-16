package com.revature.models;

public class AccountUser {

    private int userId;
    private int accountId;

    public AccountUser(int userId, int accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public int getAccountId() {
        return accountId;
    }
}
