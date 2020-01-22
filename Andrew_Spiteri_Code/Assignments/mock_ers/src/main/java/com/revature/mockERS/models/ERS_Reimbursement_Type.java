package com.revature.mockERS.models;

public enum ERS_Reimbursement_Type {
    LODGING("Lodging"), TRAVEL("Travel"), FOOD("Food"), OTHER("Other");

    private String type;

    ERS_Reimbursement_Type(String type){
        this.type = type;
    }

    public static ERS_Reimbursement_Type getTypeById(Integer id){
        ERS_Reimbursement_Type type = null;
        switch (id){
            case 1:
                type = ERS_Reimbursement_Type.LODGING;
                break;
            case 2:
                type = ERS_Reimbursement_Type.TRAVEL;
                break;
            case 3:
                type = ERS_Reimbursement_Type.FOOD;
                break;
            case 4:
                type = ERS_Reimbursement_Type.OTHER;
        }
        return type;
    }

    @Override
    public String toString() {
        return  type;
    }
}
