package com.revature.mockERS.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ERS_Reimbursement_Type {
    LODGING(1,"Lodging"), TRAVEL(2,"Travel"), FOOD(3,"Food"), OTHER(4,"Other");

    private String type;
    private Integer id;

    ERS_Reimbursement_Type(Integer id,String type){
        this.id = id;
        this.type = type;
    }

    @JsonValue
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  type;
    }
}
