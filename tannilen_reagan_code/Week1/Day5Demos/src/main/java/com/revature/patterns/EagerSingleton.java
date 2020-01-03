package com.revature.patterns;

public class EagerSingleton {
    private static EagerSingleton myNewSingleton=new EagerSingleton();
    private EagerSingleton() {
        super();;
    }
    public static EagerSingleton getInstance() {
        return myNewSingleton;
    }
}
