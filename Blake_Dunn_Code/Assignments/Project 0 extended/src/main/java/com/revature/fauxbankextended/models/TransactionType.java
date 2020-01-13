package com.revature.fauxbankextended.models;

public enum TransactionType {

    DEPOSIT("Deposit"), WITHDRAW("Withdraw"), TRANSFER("Transfer");

    private String transactionName;

    TransactionType(String name) {
        this.transactionName = name;
    }

    @Override
    public String toString() {
        return transactionName;
    }
}
