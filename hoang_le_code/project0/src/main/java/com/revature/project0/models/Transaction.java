package com.revature.project0.models;

public class Transaction {
    private Integer transactionId;
    private String transactionType;
    private Double amount;
    private Double remain;

    public Transaction() {
        super();
    }

    public Transaction(Integer transactionId, String transactionType, Double amount, Double remain) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.remain = remain;
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
        return remain;
    }

    public void setRemain(Double remain) {
        this.remain = remain;
    }


}
