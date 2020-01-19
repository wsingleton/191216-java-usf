package com.ers.liberation.models;

public enum ReimbursementStatus {
        PENDING("Pending"),APPROVED("Approved"), DENIED("Denied");
         private String reimbursementStatus;

    ReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public static ReimbursementStatus getReimbursementStatusById(Integer Id){
        ReimbursementStatus reimbursementStatus = null;
        switch (Id){
            case 1:
                reimbursementStatus = DENIED;
                break;
            case 2:
                reimbursementStatus = APPROVED;
                break;
            default:
                reimbursementStatus = PENDING;
                break;
        }

        return reimbursementStatus;
    }


    @Override
    public String toString() {
        return reimbursementStatus;
    }
}
