package com.revature.mockERS.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ERS_Reimbursement_Status {
    ACCEPTED(4,"Accepted"), REJECTED(3,"Rejected"), PROCESSING(2,"Processing"), PRESPROCESSING(1,"Pre-Processing");
    private String status;
    private Integer id;

    ERS_Reimbursement_Status(Integer id, String status){
        this.status = status;
        this.id = id;
    }

    @JsonValue
    public static ERS_Reimbursement_Status getStatusById(Integer id){
        ERS_Reimbursement_Status status = null;
        switch (id){
            case 1:
                status = ERS_Reimbursement_Status.PRESPROCESSING;
                break;
            case 2:
                status = ERS_Reimbursement_Status.PROCESSING;
                break;
            case 3:
                status = ERS_Reimbursement_Status.REJECTED;
                break;
            case 4:
                status = ERS_Reimbursement_Status.ACCEPTED;
        }
        return status;
    }

    public static ERS_Reimbursement_Status getStatusByName(String name){
        ERS_Reimbursement_Status status = null;
        switch (name){
            case "Pre-Processing":
                status = ERS_Reimbursement_Status.PRESPROCESSING;
                break;
            case "Processing":
                status = ERS_Reimbursement_Status.PROCESSING;
                break;
            case "Rejected":
                status = ERS_Reimbursement_Status.REJECTED;
                break;
            case "Accepted":
                status = ERS_Reimbursement_Status.ACCEPTED;
        }
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  status;
    }
}
