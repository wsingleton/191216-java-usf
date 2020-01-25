package com.revature.ers.models;

public enum Status {
    PENDING(1, "Pending"), APPROVED(2, "Approved"), DENIED(3, "Denied"), LOCKED(4, "Locked");

    private int id;
    private String name;

    Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Status getById(int id) {
        for (Status status : Status.values()) {
            if (status.id == id) {
                return status;
            }
        }
        return Status.LOCKED;
    }

    public int getId() {
        return id;
    }

}
