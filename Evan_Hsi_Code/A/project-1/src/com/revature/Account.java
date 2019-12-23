package com.revature;

import java.util.*;

public class Account {

    private int actId;
    private double balance;
    private ArrayList<Transaction> transactions;
    private Type type;
    private int ownerID;

    public Account() {
        this.transactions = new ArrayList<Transaction>();
        this.balance = 0.00;
    }

    public Account(int actId, int balance, Type type, int ownerID) {
        this.actId = actId;
        this.balance = balance;
        this.type = type;
        this.ownerID = ownerID;
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return actId == account.actId &&
                Double.compare(account.balance, balance) == 0 &&
                ownerID == account.ownerID &&
                Objects.equals(transactions, account.transactions) &&
                type == account.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actId, balance, transactions, type, ownerID);
    }

    @Override
    public String toString() {
        return "Account{" +
                "actId=" + actId +
                ", balance=" + balance +
                ", type=" + type +
                ", ownerID=" + ownerID +
                '}';
    }
    public String serialString() {
        return actId + " " + balance + " " + type + " " + ownerID;
    }

}
