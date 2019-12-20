package com.revature.models;

/*
    Interfaces in Java act as a "contract, what this means is that the abstract
    methods defined within the interface will be required to be implemented by
    all concrete classes which implement this interface.

    Prior to java 8, interfaces could only have fields (which were implicitly
    public static, and final) and method stubs.  Since Java 8, we have the
    ability to declare :"default methods - or methods that have implementation
    within our interfaces.

    Types of interfaces:
        Standard interface
            regular interface, containing various firlds and methods (either
            abstract or default)
        Functional interface
            interfaces that contain ONE AND ONLY ONE abstract method
            able be used with lambda experssions (arrow notation)
            examples: Comparable, Comparator, Runnable
        Marker Interface
            interfaces that contain no abstract methods at all
            kind of an artifact of Java prior to the intro of annotations
            example: Serializable, Cloneable, Remote
 */

// Interfaces are implicitly abstract.
public interface InterfaceA {
    //All fields are implicitly declared public static final
    int MY_INT = 42;

    //Method stubs are implicitly declared abstract in interfaces
    void doSomething();

    //Interfaces are allowed to have static methods
    //Cannot be overridden
    static int fetchnumber(){
        return 99;
    }
    //Since Java 8, interfaces can have non-static methods with
    //implementation (default)
    //Can be overridden
    default void doSomethingElse(){
        System.out.println("Doing something else.");
    }

}
