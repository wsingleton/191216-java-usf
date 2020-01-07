package com.liberationbank.models;

import java.util.Objects;

public class Account {
    private Integer id;
    private Integer ownerId;
    private Integer accountNumber;
    private Double balance;
    private AccountType accountType;

    public Account(Integer Id, Integer OwnerId, Integer accountNumber, Double balance, AccountType accountType) {
        this.id = Id;
        this.ownerId = OwnerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
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
        return Objects.equals(id, account.id) &&
                Objects.equals(ownerId, account.ownerId)&&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(balance, account.balance) &&
                accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,ownerId, accountNumber, balance, accountType);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
