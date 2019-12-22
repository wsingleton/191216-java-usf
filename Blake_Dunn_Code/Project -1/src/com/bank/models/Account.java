package com.bank.models;

import java.util.Objects;

public class Account extends User {

    int iD = getId();
    public double balance;

    public Account() {
        super();
    }

    public Account(int id, double b) {

        this.iD = id;
        this.balance = b;

    }

    public void display(Account iD) {

    }

    public void deposit(Account iD) {

    }

    public void checkBalance(Account iD) {

    }

    public void withdraw(Account iD) {

    }




    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return iD == account.iD &&
                Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iD=" + iD +
                ", balance=" + balance +
                '}';
    }
}
