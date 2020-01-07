package com.revature.models;

public enum AccountType {

    CHECKING("Checking"), SAVINGS("Savings"), MONEY_MARKET("Money Market"), CD("Cd"), IRA("IRA");

    private String accountName;

    private AccountType(String name){
        this.accountName =name;
    }

    @Override
    public String toString(){
        return accountName;
    }



}
