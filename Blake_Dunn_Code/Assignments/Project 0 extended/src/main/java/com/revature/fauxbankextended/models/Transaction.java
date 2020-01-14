package com.revature.fauxbankextended.models;

import java.util.Objects;

public class Transaction {

    private Integer transId;
    private Integer userId;
    private Integer acctId;
    private Double amount;
    private TransactionType type;
    private String date;

    public Transaction () {
        super();
    }

    public Transaction(Integer userId, Integer acctId, Double amount, TransactionType type) {
        this.userId = userId;
        this.acctId = acctId;
        this.amount = amount;
        this.type = type;
    }

    public Transaction(Integer transId, Integer userId, Integer acctId, Double amount, TransactionType type) {
        this.transId = transId;
        this.userId = userId;
        this.acctId = acctId;
        this.amount = amount;
        this.type = type;
    }

    public Transaction(Integer transId, Integer userId, Integer acctId, Double amount, TransactionType type, String date) {
        this.transId = transId;
        this.userId = userId;
        this.acctId = acctId;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
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
        return Objects.equals(transId, that.transId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(acctId, that.acctId) &&
                Objects.equals(amount, that.amount) &&
                type == that.type &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transId, userId, acctId, amount, type, date);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId=" + transId +
                ", userId=" + userId +
                ", acctId=" + acctId +
                ", amount=" + amount +
                ", type=" + type +
                ", date='" + date + '\'' +
                '}';
    }
}
