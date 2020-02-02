package com.revature.models;

public enum ReimbursementType {
    LODGING(3, "Lodging"), TRAVEL(2, "Travel"), FOOD(4, "Food"), OTHER(1, "Other");
    private int id;
    private String name;

    ReimbursementType(Integer id, String name) {
        this.id = id;
        this.name = name;
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
        return name;
    }
}
