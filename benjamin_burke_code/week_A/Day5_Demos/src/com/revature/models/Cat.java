package com.revature.models;

import java.util.Objects;

public  class Cat extends Animal {

    private int numberOfLives; //variable shadowing Animal.numberOfLives
    private String breed;
    private boolean hasFur;

    public Cat(){
        System.out.println("Cat constructor called");
        this.numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasFur =  true;
    }
    //another way to instantiate the cat if you don't want it to have the default vaule
    public Cat( int numberOfLives, String breed, boolean hasFur) {

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

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
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
                hasFur == cat.hasFur &&
                Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfLives, breed, hasFur);
    }
}
