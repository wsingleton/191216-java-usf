package com.ers.liberation.models;

public enum ReimbursementStatus {
        PENDING(3,"Pending"),APPROVED(2,"Approved"), DENIED(1,"Denied");
        private Integer id;
         private String reimbursementStatus;

    ReimbursementStatus(Integer id, String reimbursementStatus) {
        this.id = id;
        this.reimbursementStatus = reimbursementStatus;
    }

    public Integer getId() {
        return id;
    }

    public static ReimbursementStatus getReimbStatusById(Integer id){
        for (ReimbursementStatus reimbursementStatus : ReimbursementStatus.values()) {
            if (reimbursementStatus.id == id) {
                return reimbursementStatus;
            }
        }
        return ReimbursementStatus.PENDING;
    }


    @Override
    public String toString() {
        return reimbursementStatus;
    }
}
