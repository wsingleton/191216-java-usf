package com.revature.models;

/*
    A class can extend one and only one class, while also implementing as many
    interfaces as needed. The only time issues arise from implementing multiple
    interfaces is when there is a naming collision between inherited methods from
    those interfaces.
 */
public class InterfaceImpl extends Animal implements InterfaceA, InterfaceB {

    @Override
    public void makeSound() {
        System.out.println("sounds...");
    }

    @Override
    public void doSomething() {
        System.out.println("stuff...");
    }

}
