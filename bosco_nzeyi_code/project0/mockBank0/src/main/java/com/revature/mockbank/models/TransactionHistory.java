package com.revature.mockbank.models;

import java.util.Objects;

public class TransactionHistory {

    private int activityId;
    private int userId;
    private int accountId;
    private String activityDate;
    private String transactionDetails;
    private double amount;

    public TransactionHistory() {
        super();
    }

    public TransactionHistory(int activityId, int userId, int accountId, String activityDate, String transactionDetails, double amount) {
        this.activityId = activityId;
        this.userId = userId;
        this.accountId = accountId;
        this.activityDate = activityDate;
        this.transactionDetails = transactionDetails;
        this.amount = amount;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionHistory)) return false;
        TransactionHistory that = (TransactionHistory) o;
        return getActivityId() == that.getActivityId() &&
                getUserId() == that.getUserId() &&
                getAccountId() == that.getAccountId() &&
                Double.compare(that.getAmount(), getAmount()) == 0 &&
                Objects.equals(getActivityDate(), that.getActivityDate()) &&
                Objects.equals(getTransactionDetails(), that.getTransactionDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(), getUserId(), getAccountId(), getActivityDate(), getTransactionDetails(), getAmount());
    }

    @Override
    public String toString() {
        return "     " + activityId + "               " + userId + "                   " + accountId + "                     " +
                activityDate.substring(0, 16) + "                   " + transactionDetails + "               " + amount + "";
    }
}
