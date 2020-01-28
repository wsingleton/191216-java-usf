package com.revature.project1.models;

public enum Type {

    LODGING(1, "LODGING"), TRAVEL(2, "TRAVEL"), FOOD(3,"FOOD"), OTHER(4, "OTHER");

    private Integer id;
    private String type;

    Type(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public static Type getTypeById(int id) {

        Type type = null;

        switch (id) {
            case 1:
                type = Type.LODGING;
                break;
            case 2:
                type = Type.TRAVEL;
                break;
            case 3:
                type = Type.FOOD;
                break;
            default:
                type = Type.OTHER;
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
