package com.revature.mockbank.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Account {

    private int account_id;
    private AccountType account_type;
    private AccountAccess account_access;
    private double balance;
    private ArrayList<String> accountHistory = new ArrayList<>();

    public Account() {
        super();
    }

    public Account(int account_id, AccountType account_type, AccountAccess account_access, double balance) {
        this.account_id = account_id;
        this.account_type = account_type;
        this.account_access = account_access;
        this.balance = balance;
    }

    public Account(int account_id, AccountType account_type, AccountAccess account_access, double balance, ArrayList<String> accountHistory) {
        this.account_id = account_id;
        this.account_type = account_type;
        this.account_access = account_access;
        this.balance = balance;
        this.accountHistory = accountHistory;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public AccountType getAccount_type() {
        return account_type;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }

    public AccountAccess getAccount_access() {
        return account_access;
    }

    public void setAccount_access(AccountAccess account_access) {
        this.account_access = account_access;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getAccountHistory() {
        return accountHistory;
    }

    public void setAccountHistory(ArrayList<String> accountHistory) {
        this.accountHistory = accountHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getAccount_id() == account.getAccount_id() &&
                Double.compare(account.getBalance(), getBalance()) == 0 &&
                getAccount_type() == account.getAccount_type() &&
                getAccount_access() == account.getAccount_access() &&
                Objects.equals(getAccountHistory(), account.getAccountHistory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccount_id(), getAccount_type(), getAccount_access(), getBalance());
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account_type=" + account_type +
                ", account_access=" + account_access +
                ", balance=" + balance +
                '}';
    }
}
