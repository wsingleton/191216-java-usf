package com.revature.models;

/*
Interfaces act as contract. i.e they require classes that implement the interface to implement all methods defined within the interface.
Prior to java 8, interfaces could only have fields which are implicitly public, public and final.
Now it's possible to declare default methods that have implementation within the interface.

Type of interface:

1. Standard Interface: regular interfaces containing regular fields and methods either default or abstract).

2. Functional Interface:
3. Marker Interface: contains no abstract methods at all.
 */


public interface InterfaceA {

    // You can not declare empty fields in an interface. Interface fields are implicitly public, static and final.
    // some like this cannot work: int MY_INT;
    int MY_INT = 40; // This work because the field value is declared.

    // all method declared in interfaces are implicitly abstract. and there is no need to declare that as they are abstract by default.
    void doSomething();

    default void doSomethingElse () {

    }

}
