/*
We are going to create an abstract class called animal. We just need to add abstract before declaring the class.
An abstract class is a class that cannot be instatiated on its own.
Abstract class contains unimplemented methods that must be overridden by a concrete subclass.

Abstract classes do not need their methods to also be abstract.
 */

package com.revature.models;

import java.util.Objects;

public abstract class Animal {

    public int numberOfLives = 1;

    public Animal(){
        super(); // we don't need to do this. A class has a built-in constructor to call the super by default.
    }

    public Animal (int lives){
        this.numberOfLives = lives;
    }

    /*
    Abstract method don't have an actual implementation (body). They just depict a method signature.
   see ex below.
     */

    public abstract void makeSound();

    /*
    Abstract classes can have metthods with implementation, but it's still possible for subclasses to override such implementation.
    eg. below
     */
    public void exist(){
        System.out.println("the animal exists.....! ");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return numberOfLives == animal.numberOfLives;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfLives);
    }
}
