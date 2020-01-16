package com.revature.models;

public class AccountUser {
    private int id;
    private int accountId;

    public AccountUser(int id, int accountId) {
        this.id = id;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public double getAccountId() {
        return accountId;
    }
}
