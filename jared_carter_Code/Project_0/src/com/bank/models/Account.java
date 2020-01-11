package com.bank.models;

import java.util.Objects;

public class Account {

    private double balance;
    private int accountNumber;
    private String password;
    private String username;

   public Account(String username, String password, double balance) {
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public Account() {

    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }

    public String accountSerialize() {
        return username + " " + password + " " + accountNumber + " " + balance;
    }

    public int hash() {
        return Objects.hashCode(username);
    }


}
