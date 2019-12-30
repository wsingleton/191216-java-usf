package com.revature;

public class Account {
    /*Attempting to make the account number by adding to a static variable with an initial value given val.
    then increase that number by 1 after every variable is make.
    */
    private double balance;
    private int accountNumber;
    private static int accounts = 1017;

    Account(){
        accountNumber = accounts ++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }






}
