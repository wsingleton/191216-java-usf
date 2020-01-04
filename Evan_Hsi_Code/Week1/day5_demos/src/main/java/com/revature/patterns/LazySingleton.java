package com.revature.patterns;

public class LazySingleton {

    public int value;

    private static LazySingleton mySingleton;

    private LazySingleton() {
        super();
    }

    public static LazySingleton getInstance() {
        if (mySingleton ==  null) return mySingleton = new LazySingleton();
        return mySingleton;
    }
}
