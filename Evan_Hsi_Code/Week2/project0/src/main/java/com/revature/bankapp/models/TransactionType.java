package com.revature.bankapp.models;

public enum TransactionType {

    DEPOSIT("Deposit"), WITHDRAWAL("Withdrawal"),
    TRANSIN("Transfer In"), TRANSOUT("Transfer Out");

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
            case 3:
                transactionType = TRANSIN;
                break;
            case 4:
                transactionType = TRANSOUT;
                break;
            default:
                transactionType = DEPOSIT;
        }
        return transactionType;
    }
}
