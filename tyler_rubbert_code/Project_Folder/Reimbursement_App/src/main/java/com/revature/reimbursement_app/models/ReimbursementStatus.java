package com.revature.reimbursement_app.models;

public enum ReimbursementStatus {

    APPROVED(1, "Approved"), DENIED(2, "Denied"), PENDING(3, "Pending");

    private int id;
    private String name;

    ReimbursementStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ReimbursementStatus getById(int id) {
        switch (id) {
            case 1:
                return APPROVED;
            case 2:
                return DENIED;
            default:
                return PENDING;
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
