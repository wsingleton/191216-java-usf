package com.revature.models;
/*
Interfaces in java act as a contract, what this means is that the abstract
methods defined within the interface will be required to be implemented by
all concrete classes which implement this interface.

Prior to java 8 interfaces could only have fields(which were implicitly
public, static, and final)and method stubs. Since Java 8, we have the
ability to declare default methods- or methods that have implementation
 within our interface

Interfaces in Java act as a "contract", what this means is that the abstract
    methods defined within the interface will be required to be implemented by
    all concrete classes which implement this interface.
    Prior to Java 8, interfaces could only have fields (which were implicitly
    public, static, and final) and method stubs. Since Java 8, we have the
    ability to declare "default" methods - or methods that have implementation
    within our interfaces.

    Types of interfaces:
        - Standard interface
            + regular interface, containing various fields and methods (either
              abstract or default)

        - Functional interface
            + interfaces that contain ONE AND ONLY ONE abstract method
            + able be used with lambda expressions (arrow notation)
            + examples: Comparable, Comparator, Runnable

        - Marker interface
            + interfaces that contain no abstract methods at all
            + kinda an artifact of Java prior to the intro of annotations
            + examples: Serializable, Cloneable, Remote
 */
//interfaces are implicitly abstract
public abstract interface InterfaceA {
    // all fields declared within interfaces are implicitly public, static, final
    int MY_INT = 42;
    // all methods stubs declared within interfaces are implicitly abstract
    void doSomething();

    //interfaces are allowed to have static methids
    static int fetchNumber(){
        return 99;
    }

    default void doSomethingCool(){

    }
}
