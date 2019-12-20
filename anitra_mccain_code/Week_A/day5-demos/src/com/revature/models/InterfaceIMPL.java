package com.revature.models;

public class InterfaceIMPL extends Animal implements InterfaceA, InterfaceB {
    @Override
    public void makeSound() {
        System.out.println("sounds....");
    }

    @Override
    public void doSomething() {
        System.out.println("stuff...");
    }
}
