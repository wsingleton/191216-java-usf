package com.revature.models;

import java.io.Serializable;
/*
Interfaces can extended as many other interfaces as needed. However, they cannot inherit from the class or enum
 */
public interface InterfaceB extends InterfaceA, Serializable {

    void doSomething();

    default void doSomethingElse() {
        System.out.println("InterfaceB is doing something else....");
    }
}
