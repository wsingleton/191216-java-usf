package com.revature.models;

public enum AccountType {

    CHECKING("Checking"), SAVINGS("Savings"), MONEY_MARKET("Money Market"), CD("Cd"), IRA("IRA");

    private String accountName;
    public static AccountType getAccountTypeById(int id) {
        AccountType accountName = null;
        switch (id) {
            case 1:
                accountName = CHECKING; break;
            case 2:
                accountName = SAVINGS; break;
            case 3:
                accountName = MONEY_MARKET; break;
            case 4:
                accountName = CD; break;
            default:
                accountName = IRA;

        }
        return accountName;
    }

    private AccountType(String name){
        this.accountName =name;
    }

    @Override
    public String toString(){
        return accountName;
    }



}
