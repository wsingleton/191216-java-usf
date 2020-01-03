package com.revature.patterns;

public class EagerSingleton {

    public static EagerSingleton mySingleton = new EagerSingleton();

    private EagerSingleton(){
        super();
    }

    public static EagerSingleton getInstance(){
        return mySingleton;
    }
}
