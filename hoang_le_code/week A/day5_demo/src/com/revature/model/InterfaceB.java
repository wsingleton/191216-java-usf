package com.revature.model;

import java.io.Serializable;

/*
    imterfaces can extends as many as interfaces as needed, however ,
    they can not ingerit from a class
    or enum at all
 */
public interface InterfaceB extends InterfaceA, Serializable {
    void doSomeThing();
    default void doSomeThingElse()
    {
        System.out.println("inter face b do song thing else ");
    }


}
