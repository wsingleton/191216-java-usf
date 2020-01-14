package com.revature.bank.models;

import java.util.Objects;

public class Account {
    private Integer acctId;
    private Double balance;

    public Account(){
        super();
    }

    public Account(Integer acctId, Double balance) {
        this.acctId = acctId;
        this.balance = balance;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
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
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctId, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "acctId=" + acctId +
                ", deposit=" + balance +
                '}';
    }
}
