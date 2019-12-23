package com.revature.models;
/* Interfaces in Java act as a "contract", what this means is that the abstarct methods defined within the interface
 will be required to be implemented by all concrete classes which implement this interface.

 Prior to Java 8, interfaces could only have fields(which were implicitly
 public,static,and final) and method stubs. since java 8, we have the ability to declare
 "default"methods -or method that have implementation within our interfaces
 -Standard interface
 +regular interface, containing various fields and methods(either
 abstract or default)
 -Functional interface
 +interfaces that contain ONE AND ONE abstract method
 +able be used with lambda expressions(arrow notation)
 +examples: comparable, comparator, Runnable

 -Marker interface
 +interfaces that contain no abstarct methods at all
 +kinda an artfact of Java prior to the intro of annotations
 +examples :serializable, cloneable, Remote
 */
//interfaces are implicitly abstract

public  interface InterfaceA {
    //all fields declared within interfaces are implicitly public,static,final

    int MY_INT =42;
    //All method stub declared within interfaces are implicitly abstract

    void doSomething();

    //interfaces are allowed to have static method
    static int fetchNumber(){
        return 99;
    }

    //since java 8,interfaces can have non=static methods with implementation(default)
    default void  doSomethingElse() {
        System.out.println("Interface is doing something else.");
    }
}
