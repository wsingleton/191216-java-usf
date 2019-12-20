package com.revature.models;

//Interfaces in  Java act as a "contract", what this means is that the abstract methods defined
//within the interface will be required to be implemented by all concrete classes which implement
//this interface.

//Prior to Java 8, interfaces could only have fields(which are implicitly public, static, and final) and method stubs.
//Since Java 8, we have the ability to declare "default" methods - or methods that have implementation
//within our interfaces.

//interfaces are implicitly abstract
/*
Types of interfaces:
    - Standard interface
        +regular interface, containing various fields and methods (either abstract or default)
    - Functional interfaces
        + interfaces that contain ONE AND ONLY ONE abstract method
        + able to be used with lambda expressions (arrow notation)
        + examples: Comparable, Comparator, Runnable

    - Marker interface
        +interfaces that contain no abstract methods at all
        +kinda an artifact of Java prior ti the intro of annotation
        +examples: Serializable, Cloneable, Remote

 */

public interface InterfaceA {

    //All fields declared within interfaces are implicitly public, static, final
    int MY_INT = 42;

    //All method stubs declared within interfaces are implicitly abstract
    void doSomething();

    //Interfaces are allowed to have static methods
    //Cannot be Overridden
    static int fetchNumber() {
        return 99;
    }

    //Since Java 8, interfaces can have non-static methods with implementation (default)
    //Can be Overridden
    default void doSomethingElse() {
        System.out.println("InterfaceA is doing something else.");
    }
}

