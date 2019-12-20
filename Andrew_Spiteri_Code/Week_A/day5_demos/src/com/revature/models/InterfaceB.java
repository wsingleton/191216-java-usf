package com.revature.models;

import java.io.Serializable;

/*
    Interfaces can extend as many other interfaces as needed.  However, they cannot
    inherit from a class or enum at all.

    Deadly diamond problem.
 */

public interface InterfaceB extends InterfaceA, Serializable {

    void doSomething();

    //Why use default methods in interfaces?
    default void doSomethingElse(){
        System.out.println("InterfaceB is doing something else.");
    }
}
