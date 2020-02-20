package com.revature.models;

public enum Status {
    READ("Read"), UNREAD("Unread");

    private String statusName;

    Status(String name) {
        this.statusName = name;
    }

    @Override
    public String toString() {
        return this.statusName;
    }
}
