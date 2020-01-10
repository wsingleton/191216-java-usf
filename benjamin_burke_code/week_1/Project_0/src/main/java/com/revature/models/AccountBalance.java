package com.revature.models;

import java.util.Objects;

public class AccountBalance {


    private Integer Id;
    private Integer accountNumber;
    private Double balance;
    private AccountType accountType;

    //do i need to add the id too?
    public AccountBalance(Integer id, Double balance){
        Id = id;
        this.balance = balance;
    }

    public AccountBalance(Integer id, Integer accountNumber, Double balance, AccountType accountType) {
        this(id, balance);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
        AccountBalance that = (AccountBalance) o;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(balance, that.balance) &&
                accountType == that.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, accountNumber, balance, accountType);
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "Id=" + Id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
