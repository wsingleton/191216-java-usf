package com.revature.models;

public enum ReimbursementStatus {
    PENDING(1,"Pending"),APPROVED(2,"Approved"),

    DENIED(3,"Denied");

    private Integer id;
    private String reimbursementStatus;

    ReimbursementStatus(Integer id, String reimbursementStatus) {
        this.id = id;
        this.reimbursementStatus = reimbursementStatus;
    }

    public static ReimbursementStatus getReimbursementStatusById(Integer id) {
        for (ReimbursementStatus reimbursementStatus : ReimbursementStatus.values()) {
            if (reimbursementStatus.id == id) {
                return reimbursementStatus;
            }
        }
        return ReimbursementStatus.PENDING;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return reimbursementStatus;
    }
}
