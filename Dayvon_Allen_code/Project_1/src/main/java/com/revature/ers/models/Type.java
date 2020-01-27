package com.revature.ers.models;

public enum Type {
    CERTIFICATION(1, "Certification"), RELOCATION(2, "Relocation"), MISCELLANEOUS(3, "Miscellaneous"), FOOD(4, "food"),
    LODGING(5, "lodging"),TRAVEL(6, "travel"), OTHER(7, "other"),LOCKED(8, "locked");

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
        return Type.LOCKED;
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
