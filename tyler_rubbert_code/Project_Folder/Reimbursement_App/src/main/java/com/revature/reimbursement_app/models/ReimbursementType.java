package com.revature.reimbursement_app.models;

public enum ReimbursementType {

    LODGING(1, "Lodging"), TRAVEL(2, "Travel"), FOOD(3, "Food"), OTHER(4, "Other");

    private int id;
    private String name;

    ReimbursementType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ReimbursementType getById(int id) {
        switch(id) {
            case 1:
                return LODGING;
            case 2:
                return TRAVEL;
            case 3:
                return FOOD;
            default:
                return OTHER;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}
