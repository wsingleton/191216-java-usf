package com.ers.liberation.models;

public enum ReimbursementType {
    LODGING("Lodging"),TRAVEL("Travel"),FOOD("Food"),OTHER("Other");
    private String reimbursementType;

    ReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    public static ReimbursementType getReimbursementTypeById(Integer Id){
        ReimbursementType reimbursementType = null;
        switch (Id){
            case 1:
                reimbursementType = LODGING;
                break;
            case 2:
                reimbursementType = TRAVEL;
                break;
            case 3:
                reimbursementType = FOOD;
                break;
            default:
                reimbursementType = OTHER;
                break;
        }

        return reimbursementType;
    }


    @Override
    public String toString() {
        return "ReimbursementType{" +
                "reimbursementType='" + reimbursementType + '\'' +
                '}';
    }
}
