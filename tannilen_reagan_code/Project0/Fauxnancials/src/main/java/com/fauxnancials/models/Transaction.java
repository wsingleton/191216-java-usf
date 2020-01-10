package com.fauxnancials.models;

import java.util.Objects;

public class Transaction {
    private int transaction;
    private int account;
    private TransType transType;
    private double transAmmt;
    private String date;
    public Transaction(int transaction, int account, TransType transType, double transAmmt, String date) {
        this.transaction = transaction;
        this.account = account;
        this.transType = transType;
        this.transAmmt = transAmmt;
        this.date = date;
    }
    public int getTransaction() {
        return transaction;
    }
    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }
    public int getAccount() {
        return account;
    }
    public void setAccount(int account) {
        this.account = account;
    }
    public TransType getTransType() {
        return transType;
    }
    public void setTransType(TransType transType) {
        this.transType = transType;
    }
    public double getTransAmmt() {
        return transAmmt;
    }
    public void setTransAmmt(double transAmmt) {
        this.transAmmt = transAmmt;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transaction == that.transaction &&
                account == that.account &&
                Double.compare(that.transAmmt, transAmmt) == 0 &&
                transType == that.transType &&
                Objects.equals(date, that.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash(transaction, account, transType, transAmmt, date);
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transaction=" + transaction +
                ", account=" + account +
                ", transType=" + transType +
                ", transAmmt=" + transAmmt +
                ", date='" + date + '\'' +
                '}';
    }
}
