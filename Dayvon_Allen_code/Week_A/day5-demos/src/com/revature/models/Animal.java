package com.revature.models;


import java.util.Objects;

//An abstract class is a class that can not be instantiated on its own.
// They often contain unimplemented methods that be overridden by a concrete class
//If a class is not abstract it is concrete.
//Abstract classes do not need to necessarily have to have any abstract methods in them.
// These classes are declared as abstract simply to prevent their direct instantiation
public class Animal {

    public Animal(){

    }

    public void bark(){
        System.out.println("Bark");
    }

    public static void makeNoise(){
        System.out.println("Static: making noise");
    }

//    public int numberOfLives = 1;
//
//    public Animal() {
//        super();
//        System.out.println("Animal constructor called!");
//    }
//
//    public Animal(int lives) {
//        this.numberOfLives = lives;
//    }
//
//    //abstract methods are methods that has no implementation/ don't have a body.
//    //They consist of only a method signature or "method stub"
//    public abstract void makeSound();
//
//    //Note that abstract can have method that have implementation.
//    // However, it is still possible for subclasses to override this default implementation
//    public void exist(){
//        System.out.println("The animal exists");
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Animal animal = (Animal) o;
//        return numberOfLives == animal.numberOfLives;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(numberOfLives);
//    }
//
//    @Override
//    public String toString() {
//        return "Animal{" +
//                "numberOfLives=" + numberOfLives +
//                '}';
//    }
}
