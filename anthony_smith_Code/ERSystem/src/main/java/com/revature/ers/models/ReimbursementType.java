package com.revature.ers.models;

public enum ReimbursementType {
    LODGING(1, "Lodging"), TRAVEL(2, "Travel"), FOOD(3, "Food"), OTHER(4, "Other"), LOCKED(5, "Locked");
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
        return ReimbursementType.LOCKED;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}