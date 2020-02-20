package com.revature.models;

public enum StageType {
    AWAITING("Awaiting"), SONORA_STAGE("Sonora Stage"), YUMA_STAGE("Yuma Stage");

    private String typeName;

    StageType(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
