package com.revature.ers.models;

public enum ReimbursementType {

    LODGING ("Lodging"), TRAVEL ("Travel"), FOOD ("Food"), OTHER ("Other");

    private String type;

    ReimbursementType(String type) {
        this.type = type;
    }
}
