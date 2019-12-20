package com.revature.models;

import java.util.Objects;

public class Cat extends Animal {
    private String breed;
    private int numberOfLives;
    private boolean hasFur;

    public Cat(){
        System.out.println("Cat constructor called");
        this.numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasFur = true;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public Cat(int numberOfLives, String breed, boolean hasFur) {

        this.breed = breed;
        this.numberOfLives = numberOfLives;
        this.hasFur = hasFur;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return numberOfLives == cat.numberOfLives &&
                hasFur == cat.hasFur &&
                Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed, numberOfLives, hasFur);
    }
}
