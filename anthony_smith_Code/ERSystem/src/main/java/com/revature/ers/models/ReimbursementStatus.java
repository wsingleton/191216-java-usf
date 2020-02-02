package com.revature.ers.models;

public enum ReimbursementStatus {
    APPROVED(1, "Approved"), PENDING(2, "Pending"),

    DENIED(3, "Denied"), LOCKED(4, "Locked");

    private Integer id;
    private String name;

    ReimbursementStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ReimbursementStatus getReimbursementStatusById(int id) {
        for (ReimbursementStatus reimbursementStatus : ReimbursementStatus.values()) {
            if (reimbursementStatus.id == id) {
                return reimbursementStatus;
            }
        }
        return ReimbursementStatus.LOCKED;
    }

    public int getId() {
        return id;
    }

}