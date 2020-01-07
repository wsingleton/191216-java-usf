package com.revature.fauxbank.models;

import java.util.Objects;

public class Account {

    private Integer Id;
    private Integer accountNumber;
    private Double balance;
    private AccountType accountType;

    public Account(Integer id, Double balance) {
        Id = id;
        this.balance = balance;
    }

    public Account(Integer id, Integer accountNumber, Double balance, AccountType accountType) {
        this(id, balance);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public static Integer createAccountNumber() {
        return (Integer) (int) (Math.random() * ((9999999) + 1));
    }

    public Account createNewAccount(Integer id) {

        Account newAccount = new Account(id, 0.0);
        Integer acctNum = createAccountNumber();
        newAccount.setAccountNumber(acctNum);
        newAccount.setAccountType(AccountType.CHECKING);
        return newAccount;
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
        Account account = (Account) o;
        return Objects.equals(Id, account.Id) &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(balance, account.balance) &&
                accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, accountNumber, balance, accountType);
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
