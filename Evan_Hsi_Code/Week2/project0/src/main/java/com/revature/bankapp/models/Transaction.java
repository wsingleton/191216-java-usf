package com.revature.bankapp.models;

import java.util.Objects;

public class Transaction {
    private int transactionid;
    private int accountid;
    private String date = "";
    private double amount;
    private TransactionType type = TransactionType.DEPOSIT;


    public Transaction() {
    }

    public Transaction(int transactionid, int accountid, String date, double amount, TransactionType type) {
        this.transactionid = transactionid;
        this.accountid = accountid;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionid == that.transactionid &&
                accountid == that.accountid &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(date, that.date) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionid, accountid, date, amount, type);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionid=" + transactionid +
                ", accountid=" + accountid +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
