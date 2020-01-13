package com.revature.project_0.models;

import java.util.Objects;

public class Account {

    private int accountId;
    private double balance;
    private AccountType accountType;

    public Account() {
        super();
    }

    public Account(double balance, AccountType accountType) {
        this.balance = balance;
        this.accountType = accountType;
    }

    public Account(int accountId, double balance, AccountType accountType) {
        this.accountId = accountId;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                Double.compare(account.balance, balance) == 0 &&
                accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance, accountType);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
