package com.revature.model;

import sun.awt.AWTAccessor;

import java.util.Objects;

/*
abstract class is a class that can not be instantiated on  its own
Abstract classes often contrain hnimplemented method that must be overriden by a concrate subclass


note , abstract classes do not necessarily have to have anu abstract methods contained within them . these classes are declare as avstract , simply to prevent
their direct intsntiation
 */
public abstract class Animal {
    public int numberOfLife = 1;
    public Animal(){
        super();
    }
    public Animal(int life){
        this.numberOfLife= life;
        System.out.println(" animal contructor called") ;
    }



    /*
    abstract method are method have no implementation, they sonsist only og methd signature .
    and are often referces to a next book
     */


    /*
    NOT THAT ABSTRACT CLASSED can have method with emplemantation
    However, it is atill possible for subclasses to override this default implementation
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return numberOfLife == animal.numberOfLife;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfLife);
    }

    public abstract void makeSound();


    @Override
    public String toString() {
        return "Animal{" +
                "numberOfLife=" + numberOfLife +
                '}';
    }
}
