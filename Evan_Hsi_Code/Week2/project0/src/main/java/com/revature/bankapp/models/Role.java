package com.revature.bankapp.models;

public enum Role {

    ADMIN("Admin"), MANAGER("Manager"),
    BASIC_MEMBER("Basic Member");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }

    public static Role getRoleByID(int id) {
        Role role = null;
        switch (id) {
            case 1:
                role = ADMIN;
                break;
            case 2:
                role = MANAGER;
                break;
            default:
                role = BASIC_MEMBER;
        }

        return role;
    }


}
