package com.revature.models;

import java.util.Objects;

/*
    An abstract class is a class that cannot be instantiated on ite own.
    Abstract classes often contain unimplemented methods that MUST be
    overridden by a concrete subclass.

    Note that abstract classes do not necessarily have to have any
    abstract methods contained within them. These classes are declared
    as abstract, simply to prevent their direct instantiation.
 */
public abstract class Animal {

    public int numberOfLives = 1;

    public Animal(){
        super(); //not required, because super() is implicitly declared
        System.out.println("Animal constructor called");
    }

    public Animal(int lives){
        this.numberOfLives = lives;
    }

    /*
        Abstract methods are methods that have no implementation (or body).
        THey consist only of a method signature, and are often referred
        to as method stubs.
     */
    public abstract void makeSound();

    /*
        The abstract classes can have methods with implementation.
        However, it is still possible for subclasses to
        override this default implementation.
     */
    public void exist() {
        System.out.println("The animal exists.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return numberOfLives == animal.numberOfLives;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfLives);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "numberOfLives=" + numberOfLives +
                '}';
    }
}
