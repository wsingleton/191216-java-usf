package com.revature.models;

import java.util.Objects;

public class Cat extends Animal {
    @Override
    public void makeSound() {
               System.out.println("Meow");


    }
    private int numberOfLives;
    private String breed;
    private boolean hasFur;

public Cat() {
    System.out.println("Cat constructor called");
    this.numberOfLives = 9;
    this.breed = "domestic short hair";
    this.hasFur = true;
}

    public Cat(int numberOfLives, String breed, boolean hasFur) {
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return numberOfLives == cat.numberOfLives &&
                hasFur == cat.hasFur &&
                breed.equals(cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfLives, breed, hasFur);

    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isHasFur() {
        return hasFur;
    }
}
