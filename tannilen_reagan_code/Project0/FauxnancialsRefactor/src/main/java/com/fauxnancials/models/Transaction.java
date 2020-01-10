package com.fauxnancials.models;

public class Transaction {
    private int transactionID;
    private TransType transType;
    private int acctID;
    private int userID;
    private double transAmt;
    private String transDate;

    public Transaction(int transactionID, TransType transType, int acctID, int userID, double transAmt, String transDate) {
        this.transactionID = transactionID;
        this.transType = transType;
        this.acctID = acctID;
        this.userID = userID;
        this.transAmt = transAmt;
        this.transDate = transDate;
    }
    public int getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    public TransType getTransType() {
        return transType;
    }
    public void setTransType(TransType transType) {
        this.transType = transType;
    }
    public int getAcctID() {
        return acctID;
    }
    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public double getTransAmt() {
        return transAmt;
    }
    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    }
    public String getTransDate() {
        return transDate;
    }
    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }
}
