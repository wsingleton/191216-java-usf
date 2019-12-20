package com.revature.model;


/*
interface in jaca act as a "contract", what this mean is that the abstract methods definded within tthe interface will ge require to be implemented by
all concreate classes which implement this interface

prior to java 8, interface could only have fields (which were implicity
public, static, and final ) and method stubs. Since java 8 , we have the ability to declare "default" methods or method that
have implementation within our interfaces

type of interface :
    standard interface
        + regular interface , containing various field and methods (either abstract or default)
    functional interface
        + interface that contain one and only one abstract method
        + able be used with lamda expression (arrow notation )
        + example : comparable, comparatorm runable
    Marker interface
        interface that cointain no abstract method at all
        kida an artifact at java prior to the intro of anotation
        ex : serializable, cloneable,remote
 */



// interfaces are impiccitly abstract
public interface InterfaceA {

    // All field declared within interface are inmplicitly public, static , final
     int MY_INT = 42;

     void doSomeThing();


     // interface are allowed to have static method
    // can not be overridden
     static int catchNumber(){
         return 99;
     }

     // sine java 8 , interfaces can have non static methods with implementation (default)
    //can ve overridden
    default void doSomeThingElse(){
         System.out.println("interface A do some thing else ");
    }


}
