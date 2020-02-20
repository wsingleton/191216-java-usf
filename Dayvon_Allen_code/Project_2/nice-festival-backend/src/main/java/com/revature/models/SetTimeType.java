package com.revature.models;

public enum SetTimeType {

    TWO("2:00"), TWO_THIRTY("2:30"), THREE("3:00"), THREE_THIRTY("3:30"),
    FOUR("4:00"),FOUR_THIRTY("4:30"),FIVE("5:00"),FIVE_THIRTY("5:30"),SIX("6:00"),
    SIX_THIRTY("6:30"),SEVEN("7:00"),SEVEN_THIRTY("7:30"),EIGHT("8:00"),EIGHT_THIRTY("8:30"),
    NINE("9:00"), NINE_THIRTY("9:30"),TEN("10:00"),TEN_THIRTY("10:30"),ELEVEN("11:00"),
    ELEVEN_THIRTY("11:30");

    private String typeName;

    SetTimeType(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
