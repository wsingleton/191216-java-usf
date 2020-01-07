package com.revature.mockbank.models;

public enum AccountType {

    CHECKING("Checking"), SAVING("Saving");

    private String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() { return accountType;}
}
