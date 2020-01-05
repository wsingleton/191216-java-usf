package com.revature.fauxbank.models;

public enum AccountType {

    CHECKING ("Checking"), SAVINGS ("Savings");

    private String accountName;

    AccountType(String name) {
        this.accountName = name;
    }

    @Override
    public String toString() {
        return accountName;
    }
}
