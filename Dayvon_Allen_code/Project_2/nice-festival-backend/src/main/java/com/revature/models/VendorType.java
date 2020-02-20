package com.revature.models;

public enum VendorType {
    MERCHANDISE("Merchandise"), FOOD("Food"), BEVERAGES("Beverages");

    private String typeName;

    VendorType(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return this.typeName;
    }

}
