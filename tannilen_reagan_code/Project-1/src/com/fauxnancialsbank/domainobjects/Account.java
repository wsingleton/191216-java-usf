package com.fauxnancialsbank.domainobjects;

import java.util.Objects;

public class Account {
    private int acctNum;
    private int ssn;
    private double balance;
    public Account() {
        super();
    }
    public Account(int acct, int ssn) {
        this.acctNum=acct;
        this.ssn=ssn;
        this.balance=0.0;
    }
    public Account(int acctNum, int ssn, double balance) {
        this(acctNum,ssn);
        this.balance=balance;
    }
    public int getAcctNum() {
        return acctNum;
    }
    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }
    public int getSsn() {
        return ssn;
    }
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return acctNum == account.acctNum &&
                ssn == account.ssn &&
                Double.compare(account.balance, balance) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(acctNum, ssn, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "acctNum=" + acctNum +
                ", ssn=" + ssn +
                ", balance=" + balance +
                '}';
    }
}
