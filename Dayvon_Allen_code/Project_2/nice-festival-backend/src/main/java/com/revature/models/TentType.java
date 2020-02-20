package com.revature.models;

public enum TentType {
    AWAITING("Awaiting"), MOJAVE_TENT("Mojave Tent"), SAHARA_TENT("Sahara Tent"), OOGA_BOOGA_TENT("Ooga Booga Tent");

    private String typeName;

    TentType(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
