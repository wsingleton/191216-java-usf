package com.revature.models;

import java.util.Objects;

public class Accounts {

    private Integer accountNumber;
    private Double balance;


    public Accounts(){
        super();
    }

    public Accounts(Integer accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Accounts(String username) {
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(accountNumber, accounts.accountNumber) &&
                Objects.equals(balance, accounts.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
