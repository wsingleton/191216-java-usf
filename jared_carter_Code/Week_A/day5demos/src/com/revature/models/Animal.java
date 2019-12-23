package com.revature.models;

import java.util.Objects;

public abstract class Animal {

    public int numberOfLives = 1;

    public Animal(){
        super();
        System.out.println("Animal constructor called!");

    }

    public Animal(int lives){
        this.numberOfLives = lives;
    }

    public void exist(){
        System.out.println("Animal exists");
    }

    public abstract void makeSound();

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
