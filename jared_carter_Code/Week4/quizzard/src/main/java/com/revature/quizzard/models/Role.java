package com.revature.quizzard.models;

public enum Role {

    ADMIN(1, "Admin"), DEV(2, "Dev"), BASIC_USER(3, "Basic User"),
    PREMIUM_USER(4, "Premium User"), LOCKED(5, "Locked");

    private int id;
    private String name;

    Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role getById(int id) {
        for (Role role : Role.values()) {
            if (role.id == id) {
                return role;
            }
        }
        return Role.LOCKED;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}
