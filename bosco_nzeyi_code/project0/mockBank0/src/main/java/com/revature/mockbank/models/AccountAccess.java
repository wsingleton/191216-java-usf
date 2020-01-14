package com.revature.mockbank.models;

public enum AccountAccess {

    PERSONAL("Personal"), SHARED("shared");

    private String accessName;

    AccountAccess(String accessName) {
        this.accessName = accessName;
    }

    @Override
    public String toString() { return accessName; }
}
