package com.revature.ers.models;

public enum ReimbursementType {

    LODGING ("Lodging"), TRAVEL ("Travel"), FOOD ("Food"), OTHER ("Other");

    private String type;

    ReimbursementType(String type) {
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
}
