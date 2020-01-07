package com.liberationbank.models;

public enum AccountType {

    SAVINGS("Savings"),CHECKING("Checking");

    private String accountType;

    AccountType(String accountType){ this.accountType= accountType; }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountType='" + accountType + '\'' +
                '}';
    }
}
