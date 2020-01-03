package com.revature.patterns;

public class EagerSingleton {
    private EagerSingleton mySingleton = new EagerSingleton();
    public EagerSingleton getInstance(){
//        if(mySingleton == null){
////            mySingleton = new LazySingleton();
////        }
////        return mySingleton;
        return(mySingleton == null) ? mySingleton = new EagerSingleton() : mySingleton;

    }
}
