package com.bankboi.plainjava;

public class BankAccounts {

    private int id;
    private double balance;
    private int accountOwner;

    public BankAccounts() {}

    public BankAccounts(int owner_account, double balance ) {

        super();
        this.accountOwner = owner_account;
        this.balance = balance;

    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(int accountOwner) {
        this.accountOwner = accountOwner;
    }


}

