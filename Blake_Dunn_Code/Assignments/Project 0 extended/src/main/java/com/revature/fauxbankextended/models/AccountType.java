package com.revature.fauxbankextended.models;

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

    public static AccountType getAccountTypeById(int id) {

        AccountType acctType = null;

        switch(id) {
            case 1:
                acctType = AccountType.CHECKING;
                break;
            default:
                acctType = AccountType.SAVINGS;
                break;
        }
        return acctType;
    }
}
