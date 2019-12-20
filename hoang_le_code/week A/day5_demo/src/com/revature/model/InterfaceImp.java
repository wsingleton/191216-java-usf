package com.revature.model;

/*
a class can extends
 */


public class InterfaceImp extends Animal implements InterfaceA,InterfaceB {


    @Override
    public void makeSound() {
        System.out.println("sound------");

    }

    @Override
    public void doSomeThing() {
        System.out.println(("stuff..........."));

    }
}
