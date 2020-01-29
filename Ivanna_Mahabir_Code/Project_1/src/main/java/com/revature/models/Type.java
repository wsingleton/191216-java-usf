package com.revature.models;

public enum Type {
    LODGING(1, "Lodging"), TRAVEL(2, "Travel"), FOOD(3, "Food"), OTHER(4, "Other");

    private int id;
    private String typeName;

    Type(Integer id, String type) {
        this.id = id;
        this.typeName = type; }

    public static Type getTypeById(int id){
        Type type = null;

        switch (id){
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() { return typeName; }
}
