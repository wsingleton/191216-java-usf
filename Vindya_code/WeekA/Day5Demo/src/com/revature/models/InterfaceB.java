package com.revature.models;

import java.io.Serializable;

public interface InterfaceB extends InterfaceA, Serializable {


    void doSomething();

    default void doSomethingElse(){
        System.out.println("Interface is doing somethingElse");
    }
}
