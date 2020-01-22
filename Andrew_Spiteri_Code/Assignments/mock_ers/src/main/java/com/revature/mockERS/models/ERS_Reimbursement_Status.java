package com.revature.mockERS.models;

public enum ERS_Reimbursement_Status {
    ACCEPTED("Accepted"), REJECTED("Rejected"), ON_HOLD("On Hold"), PRESPROCESSING("Pre-Processing");
    private String status;

    ERS_Reimbursement_Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
