package com.revature.models;
/*
    Interfaces in Java act as a "contract", what this means is that the abstract
    methods defined within the interface will be required to be implemented by
    all concrete classes which implement this interface.

    Prior to Java 8, interfaces could ony have fields (which were implicitly
    public, static, and final) and method stubs. Since Java 8, we have the
    ability to declare "default" methods - or methods that have implementation
    within out interfaces.

    Types of interfaces:
        - Standard Interface
            - regular interface, containing various fields methods (either abstract or default)

        - Functional Interface
            - interfaces that contain ONE AND ONLY ONE abstract method
            - able to used with lambda expressions (arrow notation)
            - examples: Comparable, Comparator, Runnable

        - Marker Interface
            - interfaces that contain no abstract methods at all
            - kinda an artifact of Java prior to the intro of annotations
            - examples: Serializable, Cloneable, Remote
 */

//interfaces are implicitly abstract
public interface InterfaceA {

    //All fields declared within interfaces are implicitly public, static, final
    int MY_INT = 42;

    //All method stubs declared within interfaces are implicitly abstract
    void doSomething();

    // Interfaces are allowed to have static methods
    // Cannot be overridden
    static int fetchNumber() {
        return 99;
    }

    //Since Java 8, interfaces can have non-static methods with implementation (default)
    // Can be overridden
    default void doSomethingElse() {
        System.out.println("InterfaceA is doing something");
    }

}
