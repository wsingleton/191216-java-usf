package com.revature.revabank.models;

public enum AccountType {

    CHECKING("Checking"), SAVING("saving");

    private String accountName;

    AccountType(String name){
        this.accountName= name;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountNmae='" + accountName + '\'' +
                '}';
    }
}
