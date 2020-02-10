package com.revature.project1.models;


public enum Status {

    PENDING(1, "PENDING"), APPROVED(2, "Approved"), DENIED(3, "Denied");

    private int id;
    private String name;

    Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Status getById(int id) {
        switch (id) {
            case 1:
                return PENDING;
            case 2:
                return APPROVED;
            default:
                return DENIED;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}
