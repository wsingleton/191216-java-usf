package com.revature.ers.models;

public enum ReimbursementStatus {

    PENDING (1,"Pending"), APPROVED (2,"Approved"), DENIED (3,"Denied");

    private int id;
    private String status;

    ReimbursementStatus(Integer id, String status) {

        this.id = id;
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

    public int getStatusId() {
        return id;
    }

    @Override
    public String toString() {
        return status;
    }

}
