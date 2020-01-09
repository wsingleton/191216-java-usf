package com.revature.revabooks.models;

public enum Role {

    ADMIN("Admin"), MANAGER("Manager"),
    PREMIUM_MEMBER("Premium Member"), BASIC_MEMBER("Basic Member");

    private String roleName;

    // enum constructors are implicitly private
    Role(String name) {
        this.roleName = name;
    }

    public static Role getRoleById(int id) {

        Role role = null;

        switch (id) {
            case 1:
                role = Role.ADMIN;
                break;
            case 2:
                role = Role.MANAGER;
                break;
            case 3:
                role = Role.PREMIUM_MEMBER;
                break;
            default:
                role = Role.BASIC_MEMBER;
        }

        return role;

    }

    @Override
    public String toString() {
        return roleName;
    }


}
