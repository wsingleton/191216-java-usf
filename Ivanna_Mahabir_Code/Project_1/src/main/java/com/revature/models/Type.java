package com.revature.models;

public enum Type {
    LODGING("Lodging"), TRAVEL("Travel"), FOOD("Food"), OTHER("Other");

    private String typeName;

    Type(String type) { this.typeName = type; }

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
    @Override
    public String toString() { return typeName; }
}
