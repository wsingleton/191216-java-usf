package com.revature.patterns;

//class can only have one instance of its self
public class LazySingleton {

    private static LazySingleton mySingleton;
    public int value;

    private LazySingleton() {
        super();
    }

    public static LazySingleton getInstance() {
        return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
