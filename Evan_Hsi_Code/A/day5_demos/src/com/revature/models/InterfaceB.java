package com.revature.models;

import java.io.Serializable;

public interface InterfaceB extends Serializable, InterfaceA {

    void doSomething();

    default void doSomethingElse(){
        System.out.println("InterfaceB is doing something else");
    }

}
