package com.revature.models;

import java.io.Serializable;

/*
    Interfaces can extend as many other interfaces as needed. However, they cannot
    inherit from a class or enum at all.
    class extends class (Only one though)
    interface extends interface (As many as needed)
    class implements interface (As many as needed)
 */

public interface InterfaceB extends InterfaceA, Serializable {

    void doSomething();


}
