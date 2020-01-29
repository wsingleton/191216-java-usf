package com.revature.models;

public enum Role {
    FINANCE_MANAGER(1, "finance_manager"), EMPLOYEE(2, "employee"), LOCKED(3, "locked");

    private int id;
    private String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role getById (int id) {
        for (Role role: Role.values()) {
            if (role.id == id) { return role; }
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
