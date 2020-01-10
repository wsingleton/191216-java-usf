package com.revature.project0.models;

import java.util.Objects;

public class Accounts {
    private Integer accountNumber;
    private String accountType;
    private Double balance;

    public Accounts() {
        super();
    }

    public Accounts(String accountType, Double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public Accounts(Integer accountNumber, String accountType, Double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
                Objects.equals(accountType, accounts.accountType) &&
                Objects.equals(balance, accounts.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType, balance);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
