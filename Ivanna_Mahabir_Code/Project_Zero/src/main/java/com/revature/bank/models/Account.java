package com.revature.bank.models;

import java.util.InputMismatchException;
import java.util.Objects;

public class Account {
    private Integer acctId;
    private Double balance;

    public Account() {
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
        try{
            if(balance == null || balance < 0 ){
                System.out.println("Balance: " + balance + " is invalid. Setting balance to $0");
                this.balance = 0.0;
            }
            else{
                this.balance = balance;
            }}
        catch(InputMismatchException e) {
            System.out.println("Invalid Input");
            e.printStackTrace();
        }
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
                ", balance=" + balance +
                '}';
    }
}