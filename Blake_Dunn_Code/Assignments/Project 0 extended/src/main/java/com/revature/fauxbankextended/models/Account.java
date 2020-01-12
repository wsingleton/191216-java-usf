package com.revature.fauxbankextended.models;

import java.util.Objects;

public class Account {

    private Integer Id;
    private Double balance;
    private AccountType accountType;

    public Account() {
        super();
    }

    public Account(Double balance) {
        this.balance = balance;
    }

    public Account(Integer id, Double balance) {
        Id = id;
        this.balance = balance;
    }

    public Account(Integer id, Double balance, AccountType accountType) {
        this.balance = balance;
        this.Id = id;
        this.accountType = accountType;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(Id, account.Id) &&
                Objects.equals(balance, account.balance) &&
                accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, balance, accountType);
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
