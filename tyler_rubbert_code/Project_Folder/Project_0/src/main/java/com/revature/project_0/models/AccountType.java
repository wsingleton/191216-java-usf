package com.revature.project_0.models;

public enum AccountType {

    CHECKINGS("Checkings"), SAVINGS("Savings");

    private String typeName;

    AccountType(String name) {
        this.typeName = name;
    }

    public static AccountType getAccountTypeById(int id) {

        AccountType accountType = null;

        switch (id) {
            case 1:
                accountType = AccountType.SAVINGS;
                break;
            default:
                accountType = AccountType.CHECKINGS;
        }

        return accountType;

    }

    @Override
    public String toString() {
        return typeName;
    }
}
