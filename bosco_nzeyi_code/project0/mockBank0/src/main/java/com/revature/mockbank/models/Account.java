package com.revature.mockbank.models;

import java.util.ArrayList;
import java.util.Objects;

public class Account {

    private User userId;
    private AccountType accountType;
    private Double balance;
    private ArrayList<String> accountHistory = new ArrayList<>();

    public Account(User userId, AccountType accountType, Double balance, ArrayList<String> accountHistory) {
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
        this.accountHistory = accountHistory;
    }

    // a constructor with basic data. no account history
    public Account(User userId, AccountType accountType, Double balance) {
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double amount, String transactionType) {
        if(transactionType.equals("deposit")) this.balance = balance + amount;
        if (transactionType.equals("withdraw")) this.balance = balance + amount;
    }

    public ArrayList<String> getAccountHistory() {
        return accountHistory;
    }

    public void setAccountHistory(String transaction) {
        accountHistory.add(transaction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getUserId(), account.getUserId()) &&
                getAccountType() == account.getAccountType() &&
                Objects.equals(getBalance(), account.getBalance()) &&
                Objects.equals(getAccountHistory(), account.getAccountHistory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getAccountType(), getBalance(), getAccountHistory());
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", accountHistory=" + accountHistory +
                '}';
    }
}
