package com.revature.models;

import java.util.Objects;

public abstract class Mammal {
    public int numberOfLives=1;
    public int numberOfLegs=4;
    public boolean liveBirth=true;
    public char size='s';
    public Mammal(){
        super();
        System.out.println("Mammal default constructor called.");
    }
    public Mammal(int lives, char size){
        this.numberOfLives=lives;
        this.size=size;
        System.out.println("Mammal non-default constructor called.");
    }
    public abstract void cry();
    public void liveBirths(){
        System.out.println("This animal is a mammal and has live births.");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mammal mammal = (Mammal) o;
        return numberOfLives == mammal.numberOfLives &&
                numberOfLegs == mammal.numberOfLegs &&
                liveBirth == mammal.liveBirth &&
                size == mammal.size;
    }
    @Override
    public int hashCode() {
        return Objects.hash(numberOfLives, numberOfLegs, liveBirth, size);
    }
    @Override
    public String toString() {
        return "Mammal{" +
                "numberOfLives=" + numberOfLives +
                ", numberOfLegs=" + numberOfLegs +
                ", liveBirth=" + liveBirth +
                ", size=" + size +
                '}';
    }
}
