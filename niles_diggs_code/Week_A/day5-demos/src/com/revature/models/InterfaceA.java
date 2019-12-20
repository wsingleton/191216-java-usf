package com.revature.models;
/*
Interfaces in Java act as a "contract", what this means is that the abstract methods defined within the interface will be
required to be implemented by all concrete classes which implement this interface.

prior to Java 8, interfaces could only have field (which were implicitly public, static, and final) and method stubs
Since Java 8, we have the ability to declare "default" methods - or methods that have implementation within our interfaces.

Types of interfaces:
- Standard interface
        regular interface, containing various fields and methods (either abstract and default)

- Functional interface
        can contain one and only one abstract method
        able to be used with lambda expressions (arrow notation)
        examples: Comparable, Comparator, Runnable

- Marker interface
        interfaces that contain no abstract methods at all
        and artifact of Java prior to the intro of annotations
        examples: Serializable, Cloneable, Remote

 */

// Interfaces are implicitly abstract
public interface InterfaceA {

    // all fields declared within interfaces are implicitly public, static, final
    int MY_INT = 42;

    // all method stubs declared within interfaces are implicitly abstract as well
    void doSomething();

    //Interfaces are allowed to have static methods
    // cannot be overridden
    static int fetchNumber() {
        return 99;
    }

    // Since Java 8, interfaces can have non-static methods with implementation default
    // can be overridden
    default void doSomethingElse() {
        System.out.println("InterfaceA is doing something else");
    }
}
