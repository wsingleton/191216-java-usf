package com.revature.ers.models;

public enum ReimbursementType {

    LODGING (1,"Lodging"), TRAVEL (2,"Travel"), FOOD (3,"Food"), OTHER (4,"Other");

    private int id;
    private String type;

    ReimbursementType(Integer id, String type) {

        this.id = id;
        this.type = type;
    }

    public static ReimbursementType getTypeById(int id) {

        ReimbursementType type = null;

        switch (id) {
            case 1:
                type = ReimbursementType.LODGING;
                break;
            case 2:
                type = ReimbursementType.TRAVEL;
                break;
            case 3:
                type = ReimbursementType.FOOD;
                break;
            default:
                type = ReimbursementType.OTHER;
        }

        return type;
    }

    public int getTypeId() {
        return id;
    }

    @Override
    public String toString() {
        return type;
    }
}
