package com.revature.project1.models;

public enum Type {
    LODGING(1, "LODGING"),TRAVEL(2, "TRAVEL"), FOOD(3, "FOOD"),OTHER(4, "OTHER");

    private int id;
    private String name;

    Type(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Type getById(int id) {
        for (Type type : Type.values()) {
            if (type.id == id) {
                return type;
            }
        }
        return Type.OTHER;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
