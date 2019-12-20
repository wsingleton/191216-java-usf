package com.revature.models;

/*
    Interfaces in Java act as a "contract", what this means is that the abstract methods defined within
    the interface will be required to be implemented by all concrete classes which implement this interface.

    Prior to Java8, interfaces could only have fields (which were implicitly public, static, and final) and method stubs
    In Java 8, they added default methods


    -Standard interface
        + regular interface, containing various fields and methods( either abstract or default)

    -Functional interface
        + Interfaces that contain only one abstract method
        + able to be used with lambda expressions ( arrow notation)
        + examples: Comparable, Comparator, Runnable

    -Marker interface
        + interfaces that contain no abstract methods at all
        + kinda an artifact of Java prior to the intro of annotations
        + examples: Serializable, Cloneable, Remote

 */

public interface InterfaceA {

    int MY_INT = 42;        //All fields declared within interfaces are implicitly public, static, final

    void doSomething();     //All method stubs declared within interfaces are implicitly abstract

    static int fetchNumber() {
        return 99;
    }

    default void doSomethingElse() {
        System.out.println("InterfaceA is doing something else.");
    }
}
