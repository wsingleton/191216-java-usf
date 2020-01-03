package com.revature.patterns;

public class LazySingleton {

    public int value; //nothing to do with the design pattern, simply to use as a proof

    private static LazySingleton mySingleton;

    private LazySingleton() {
        super ();
    }

    public static LazySingleton getInstance() {
        if (mySingleton == null) {
            mySingleton = new LazySingleton();
        }
        return mySingleton;

        // return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;
    }
}
