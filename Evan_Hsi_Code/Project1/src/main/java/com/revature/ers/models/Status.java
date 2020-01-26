package com.revature.ers.models;

public enum Status {

    PENDING(1, "Pending"), DENIED(2, "Denied"), APPROVED(3, "Approved");

    private int id;
    private String status;


    Status() {
    }

    Status(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public static Status getById(int id) {
        for (Status status : Status.values()) {
            if (status.id == id) {
                return status;
            }
        }
        return Status.PENDING;
    }

    public int getId() { return id; }

    @Override
    public String toString() { return status; }
}
