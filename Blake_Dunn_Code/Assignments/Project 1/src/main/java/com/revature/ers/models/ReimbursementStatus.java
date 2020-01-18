package com.revature.ers.models;

public enum ReimbursementStatus {

    PENDING ("Pending"), APPROVED ("Approved"), DENIED ("Denied");

    private String status;

    ReimbursementStatus(String status) {
        this.status = status;
    }

}
