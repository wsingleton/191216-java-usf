package com.revature.models;

public class InterfaceImpl extends Animal implements InterfaceA, InterfaceB {

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public void doSomething() {
        System.out.println("InterfaceImpl is doing something");
    }

}
