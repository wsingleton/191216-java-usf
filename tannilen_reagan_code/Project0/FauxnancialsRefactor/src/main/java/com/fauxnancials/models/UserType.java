package com.fauxnancials.models;

public enum UserType {
    ADMIN("Admin"), USER("User");
    private String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public static UserType getRoleById(int i) {
        UserType type=null;
        switch (i) {
            case 1:
                type=UserType.ADMIN;
                break;
            default:
                type=UserType.USER;
                break;
        }
        return type;
    }

    @Override
    public String toString() {
        return userType;
    }
}