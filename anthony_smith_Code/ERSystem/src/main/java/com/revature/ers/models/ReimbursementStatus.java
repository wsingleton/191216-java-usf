package com.revature.ers.models;

public enum ReimbursementStatus {
     PENDING(1, "Pending"), APPROVED(2, "Approved"),

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