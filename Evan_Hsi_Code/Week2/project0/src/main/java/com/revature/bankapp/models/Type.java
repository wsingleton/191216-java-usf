package com.revature.bankapp.models;

public enum Type {

    CHECKING("Checking"), SAVINGS("Savings");

    private String type;

    Type(String type) { this.type = type; }

    public static Type getTypeByID(int id) {
        Type type = null;
        if(id == 2) type = SAVINGS;
        else type = CHECKING;
        return type;
    }
}
