package com.revature.models;

import java.util.Objects;

public class Cat extends Animal {

    private int numberOfLives; // Animal.numberOfLives is shadowed by this declaration
    private String breed;
    private boolean hasfur;

    public Cat() {
        System.out.println("cat constructor called!");
        this .numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasfur= true;
    }

    public Cat(int numberOfLives, String breed, boolean hasfur) {
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasfur = hasfur;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isHasfur() {
        return hasfur;
    }

    public void setHasfur(boolean hasfur) {
        this.hasfur = hasfur;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return numberOfLives == cat.numberOfLives &&
                hasfur == cat.hasfur &&
                Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfLives, breed, hasfur);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "numberOfLives=" + numberOfLives +
                ", breed='" + breed + '\'' +
                ", hasfur=" + hasfur +
                '}';
    }
}
