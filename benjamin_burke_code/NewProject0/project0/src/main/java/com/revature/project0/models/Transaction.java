package com.revature.project0.models;

public class Transaction {
    private Integer transactionId;
    private String transactionType;
    private Double amount;
    private Double current;

    public Transaction() {
        super();
    }

    public Transaction(Integer transactionId, String transactionType, Double amount, Double current) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.current = current;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRemain() {
        return current;
    }

    public void setRemain(Double remain) {
        this.current = current;
    }


}
