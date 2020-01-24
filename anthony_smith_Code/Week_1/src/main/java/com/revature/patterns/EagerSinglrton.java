package com.revature.patterns;

public class EagerSinglrton {

    private static EagerSinglrton mySingleton  = new EagerSinglrton();

    private EagerSinglrton(){
        super();
    }

    public static EagerSinglrton getInstance(){
        return mySingleton;
    }
}
