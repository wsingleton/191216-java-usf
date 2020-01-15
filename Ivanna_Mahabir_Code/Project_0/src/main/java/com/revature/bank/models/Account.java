package com.revature.bank.models;

import java.util.Objects;

public class Account {
    private Integer acctId;
    private String username;
    private Double balance = 0.0;

    public Account() {
        super();
    }

    public Account(Integer acctId, String username, Double balance) {
        this.acctId = acctId;
        this.username = username;
        this.balance = balance;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        Account account = (Account) o;
        return Objects.equals(acctId, account.acctId) &&
                Objects.equals(username, account.username) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctId, username, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "acctId=" + acctId +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}