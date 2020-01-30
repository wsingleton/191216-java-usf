package com.revature.models;

public enum Category {
    LODGING(1, "lodging"), TRAVEL(2, "travel"), FOOD(3, "food"), OTHER(4, "other"), LOCKED(5, "locked");

    private int id;
    private String name;

    Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Category getById (int id) {
        for (Category category : Category.values()) {
            if( category.id == id) {
                return category;
            }
        }
        return Category.LOCKED;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
