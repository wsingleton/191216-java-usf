package com.revature.models;

public abstract class Animal {

    public int numberOfLives = 1;

    public Animal(){

        System.out.println("Animal constructor called.");
    }
    public Animal(int lives) {

        this.numberOfLives= lives;
    }
    public abstract void makeSound();

    public void exist() {
        System.out.println("This animal exists.");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "numberOfLives=" + numberOfLives +
                '}';
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
        return numberOfLives;
    }
}
