package com.revature.models;
/*
To be able to use a public class to extend an abstract class, we will have to override it.
Once the red warning line is shown, we hover over it and select chose implementation to get rid of the error.
 */

import java.util.Objects;

public class Cat extends Animal{

    private int numberOfLives; // Animal.numberOfLives is shadowed by this declaration.
    private String breed;
    private Boolean hasFur;

    public Cat (){
        System.out.println("Cat constructor called");
        this.numberOfLives = 9;
        this.breed = "Domestic Short Hair";
        this.hasFur = true;
    }

    public Cat(int numberOfLives, String breed, Boolean hasFur) {
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;
    }

    public Cat(int lives, int numberOfLives, String breed, Boolean hasFur) {
        super(lives);
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;
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

    public Boolean getHasFur() {
        return hasFur;
    }

    public void setHasFur(Boolean hasFur) {
        this.hasFur = hasFur;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return getNumberOfLives() == cat.getNumberOfLives() &&
                getBreed().equals(cat.getBreed()) &&
                getHasFur().equals(cat.getHasFur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfLives(), getBreed(), getHasFur());
    }
}
