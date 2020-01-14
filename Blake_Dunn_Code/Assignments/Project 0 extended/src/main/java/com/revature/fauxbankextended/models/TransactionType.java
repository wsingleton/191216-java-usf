package com.revature.fauxbankextended.models;

public enum TransactionType {

    DEPOSIT("Deposit"), WITHDRAW("Withdraw"), TRANSFER("Transfer");

    private String transactionName;

    TransactionType(String name) {
        this.transactionName = name;
    }

    public static TransactionType getTransactionTypeById(int id) {

        TransactionType type = null;

        switch (id) {
            case 1:
                type = TransactionType.DEPOSIT;
                break;
            case 2:
                type = TransactionType.WITHDRAW;
                break;
            default:
                type = TransactionType.TRANSFER;
                break;
        }

        return type;
    }

    @Override
    public String toString() {
        return transactionName;
    }
}
