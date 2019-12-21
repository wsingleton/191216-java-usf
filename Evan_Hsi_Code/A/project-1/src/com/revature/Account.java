package com.revature;

import java.util.*;

public class Account {

    private int actId;
    private int balance;
    private ArrayList<Transaction> transactions;
    private Type type;
    private int ownerID;

    public Account() {
        this.transactions = new ArrayList<Transaction>();
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
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
    public String toString() {
        return "Account{" +
                "actId=" + actId +
                ", balance=" + balance +
                ", type=" + type +
                ", ownerID=" + ownerID +
                '}';
    }


}
