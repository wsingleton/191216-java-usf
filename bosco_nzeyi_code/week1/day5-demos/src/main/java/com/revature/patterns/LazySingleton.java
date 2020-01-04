package com.revature.patterns;

public class LazySingleton {

    private static LazySingleton mySingleton;

    private LazySingleton(){
        super();
    }

    public static LazySingleton getInstance(){
        if(mySingleton == null){
            mySingleton = new LazySingleton();
        }
        return mySingleton;
    }


}
