package com.revature.models;

public enum ReimbursementType {
    LODGING(1,"Lodging"),TRAVEL(2,"Travel"),FOOD(3,"Food"),OTHER(4,"Other");
    private Integer id;
    private String reimbursementType;

    ReimbursementType(Integer id, String reimbursementType) {
        this.id = id;
        this.reimbursementType = reimbursementType;
    }

    public static ReimbursementType getReimbursementTypeById(int id) {
        for (ReimbursementType reimbursementType : ReimbursementType.values()) {
            if (reimbursementType.id == id) {
                return reimbursementType;
            }
        }
        return ReimbursementType.OTHER;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return reimbursementType;
    }
}
