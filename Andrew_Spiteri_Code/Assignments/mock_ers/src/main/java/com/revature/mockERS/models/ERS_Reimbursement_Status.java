package com.revature.mockERS.models;

public enum ERS_Reimbursement_Status {
    ACCEPTED("Accepted"), REJECTED("Rejected"), PROCESSING("Processing"), PRESPROCESSING("Pre-Processing");
    private String status;

    ERS_Reimbursement_Status(String status){
        this.status = status;
    }

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

    @Override
    public String toString() {
        return  status;
    }
}
