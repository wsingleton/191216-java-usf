package com.revature.mockERS.models;

public enum ERS_Reimbursement_Type {
    LODGING("Lodging"), TRAVEL("Travel"), FOOD("Food"), OTHER("Other");

    private String type;

    ERS_Reimbursement_Type(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
