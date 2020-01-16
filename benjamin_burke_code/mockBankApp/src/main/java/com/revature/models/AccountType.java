package com.revature.models;

public enum AccountType {

    SAVINGS("Savings"),CHECKING("Checking");

    private String accountType;

    AccountType(String accountType){ this.accountType= accountType; }

    public static AccountType getAccountTypeById(int id) {
        AccountType accountType = null;
        switch (id) {
            case 1:
                accountType = CHECKING;
                break;
            case 2:
                accountType = SAVINGS;
                break;

            default:
                accountType = CHECKING;
        }
        return accountType;
    }
    @Override
    public String toString() {
        return "AccountType{" +
                "accountType='" + accountType + '\'' +
                '}';
    }
}
