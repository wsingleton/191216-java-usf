package com.revature.bankapp.models;

import java.util.Objects;

public class Account {

    private int accountid;
    private double balance;
    private Type type;

    public Account() {
    }

    public Account(Type type) {
        this.type = type;
    }

    public Account(int accountid, double balance, Type type) {
        this.accountid = accountid;
        this.balance = balance;
        this.type = type;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountid == account.accountid &&
                Double.compare(account.balance, balance) == 0 &&
                type == account.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountid, type);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountid=" + accountid +
                ", balance=" + balance +
                ", type=" + type +
                '}';
    }
}
