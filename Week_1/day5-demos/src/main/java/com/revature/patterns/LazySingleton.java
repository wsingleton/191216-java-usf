package com.revature.patterns;

public class LazySingleton {

    public int value; // this member has nothing to do with the singleton pattern

    private static LazySingleton mySingleton;

    private LazySingleton() {
        super();
    }

    public static LazySingleton getInstance() {

//        if (mySingleton == null) {
//            mySingleton = new LazySingleton();
//        }
//
//        return mySingleton;

        return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;

    }
}
