package com.revature.models;

public enum ReimbursementStatus {
    APPROVED(2, "Approved"), PENDING(1, "Pending"),

    DENIED(3, "Denied");

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
        return ReimbursementStatus.PENDING;
    }

    public int getId() {
        return id;
    }

}
