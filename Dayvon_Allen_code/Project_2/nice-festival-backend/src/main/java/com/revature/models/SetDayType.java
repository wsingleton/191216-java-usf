package com.revature.models;

public enum SetDayType {

    FRIDAY("Friday"), SATURDAY("Saturday"), SUNDAY("Sunday");

    private String typeName;

    SetDayType(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
