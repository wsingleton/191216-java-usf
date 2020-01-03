package com.revature.pattems;

public class EagerSingleton {
    private  static EagerSingleton mySingleTon = new EagerSingleton();
    private EagerSingleton(){
        super();
    }

    public  static EagerSingleton getInstance(){
        return mySingleTon;
    }
}
