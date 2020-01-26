package com.revature.ers.models;

public enum Type {

    LODGING(1, "Lodging"), TRAVEL(2, "Travel"), FOOD(3, "Food"), OTHER(4, "Other");

    private int id;
    private String name;

    Type() {
    }

    Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Type getById(int id) {
        for (Type type : Type.values()) {
            if(type.id == id) {
                return type;
            }
        }
        return Type.OTHER;
    }

    public int getId() { return id; }

    @Override
    public String toString() { return name; }


}
