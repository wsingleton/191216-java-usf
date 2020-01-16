package com.revature.bankapp.models;

public enum TransactionType {

    DEPOSIT("Deposit"), WITHDRAWAL("Withdrawal");

    private String transactionType;

    TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return transactionType;
    }

    public static TransactionType getTransactionTypeByID(int id) {
        TransactionType transactionType = null;
        switch (id) {
            case 2:
                transactionType = WITHDRAWAL;
                break;
            default:
                transactionType = DEPOSIT;
        }
        return transactionType;
    }
}
