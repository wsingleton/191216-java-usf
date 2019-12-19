package com.bank.models;

import java.util.Objects;

public class Account {

    private int id;
    public double balance;
    private int acctNumber;

    public Account() {
        super();
    }

    public Account(int id, double b, int an) {

        this.id = id;
        this.balance = b;
        this.acctNumber = an;

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

    public int getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(int acctNumber) {
        this.acctNumber = acctNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Double.compare(account.balance, balance) == 0 &&
                acctNumber == account.acctNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, acctNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", acctNumber=" + acctNumber +
                '}';
    }
}
