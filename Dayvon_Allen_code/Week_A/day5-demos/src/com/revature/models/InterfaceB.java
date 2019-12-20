package com.revature.models;

/*
    Interfaces in Java act as a "contract",
    what this means is that the abstract methods defined within the interface will be  required to be implemented by all concrete classes which implement this interface.

    Prior to Java 8, interfaces could only have fields (which were implicitly public, static, and final) and method stubs.
    Since Java 8, we have the ability to declare "default" methods - or methods that have implementation within our interfaces.

    Types of interfaces:

        - Standard interface
            + regular interface, containing various fields and methods (either abstract or default)

        - Functional interface
             + interfaces that contain ONE and ONLY ONE abstract method(can have fields and default methods)
             + able be used with lambda expressions (arrow notation)
             + examples: Comparable, Comparator, Runnable

        - Marker interface
              + interfaces that contain no abstract methods at all
              + kinda an artifact of java prior to the intro to annotations(Java 5)
              + examples: Serializable, Cloneable, Remote

    Interfaces are implicitly abstract.
 */

public interface InterfaceB {
    //all fields inside of an interface is implicitly final and static and  public fields must have a value
    int MY_INT = 42;

    //all method stubs are implicitly abstract in interfaces
    void doeSomething();

    //Interfaces are allowed to have static methods
    //Can't be overridden
    static int fetchNumber(){
        return 99;
    }

    //since java 8, interfaces can have non-static methods with implementation(default)
    //can be overridden
    default void doSomethingElse(){

    }
}
