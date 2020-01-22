package com.revature.ers.models;

public enum ReimbursementStatus {

    PENDING ("Pending"), APPROVED ("Approved"), DENIED ("Denied");

    private String status;

    ReimbursementStatus(String status) {
        this.status = status;
    }

    public static ReimbursementStatus getStatusById(int id) {

        ReimbursementStatus status = null;

        switch (id) {
            case 1:
                status = ReimbursementStatus.PENDING;
                break;
            case 2:
                status = ReimbursementStatus.APPROVED;
                break;
            default:
                status = ReimbursementStatus.DENIED;
        }

        return status;

    }

}
