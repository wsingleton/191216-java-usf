package com.revature.models;

public enum Status {
    APPROVED(1, "approved"), DENIED(2, "denied"), PENDING(3, "pending"), LOCKED(4, "locked");

    private int id;
    private String name;

    Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Status getById (int id) {
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

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
