package com.revature;

import java.util.Objects;

public class Account {
    /*Attempting to make the account number by adding to a static variable with an initial value given val.
    then increase that number by 1 after every variable is make.
    */
    private double balance;
    private int accountNumber;
    private String password;
    private String username;

    Account(String username, String password, int accountNumber, double balance) {
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
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
