package com.ers.liberation.models;

public enum ReimbursementType {
    LODGING(1,"Lodging"),TRAVEL(2,"Travel"),
    FOOD(3,"Food"),OTHER(4,"Other");
    private Integer id;
    private String reimbursementType;

    ReimbursementType(Integer id, String reimbursementType) {
        this.id = id;
        this.reimbursementType = reimbursementType;
    }

    public Integer getId() {
        return id;
    }

    public static ReimbursementType getReimbTypeById(int id) {
        for (ReimbursementType reimbursementType : ReimbursementType.values()) {
            if (reimbursementType.id == id) {
                return reimbursementType;
            }
        }
        return ReimbursementType.OTHER;
    }


    @Override
    public String toString() {
        return "ReimbursementType{" +
                "reimbursementType='" + reimbursementType + '\'' +
                '}';
    }
}
