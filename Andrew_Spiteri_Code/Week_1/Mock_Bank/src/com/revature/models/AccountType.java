package com.revature.models;

public enum AccountType {
    CHECKING(0), SAVINGS(1), AUTOLOAN(2), MORTGAGE(3), TEMP(4);

    private Integer id;

    AccountType(Integer id){
        this.id = id;
    }

    public Integer getId(){return id;}
}
