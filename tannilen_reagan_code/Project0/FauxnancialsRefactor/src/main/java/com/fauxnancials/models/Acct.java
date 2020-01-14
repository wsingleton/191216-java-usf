package com.fauxnancials.models;

import java.util.Objects;

public class Acct {
    private int acctID;
    private AcctType acctType;
    private double balance;
    private int userID;
    public Acct(int acctID, AcctType acctType, double balance, int userID) {
        this.acctID = acctID;
        this.acctType = acctType;
        this.balance = balance;
        this.userID=userID;
    }
    public Acct(AcctType acctType, double balance, int userID) {
        this.acctType=acctType;
        this.balance=balance;
        this.userID=userID;
    }
    public Acct() {
        super();
    }
    public int getAcctID() {
        return acctID;
    }
    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }
    public AcctType getAcctType() {
        return acctType;
    }
    public void setAcctType(AcctType acctType) {
        this.acctType = acctType;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acct acct = (Acct) o;
        return acctID == acct.acctID &&
                Double.compare(acct.balance, balance) == 0 &&
                acctType == acct.acctType;
    }
    @Override
    public int hashCode() {
        return Objects.hash(acctID, acctType, balance);
    }

    @Override
    public String toString() {
        return "Acct{" +
                "acctID=" + acctID +
                ", acctType=" + acctType +
                ", balance=" + balance +
                ", userID=" + userID +
                '}';
    }
    public String acctShow() {
        return ("Account #" + acctID + "(" + acctType.toString() + "\n" + "Current Balance: $" + balance);
    }
}
