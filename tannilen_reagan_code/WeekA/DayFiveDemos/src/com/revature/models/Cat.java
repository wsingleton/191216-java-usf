package com.revature.models;

import java.util.Objects;

public class Cat extends Mammal {
    private boolean hasFur;
    private boolean hasTail;
    public Cat(){
        System.out.println("Default cat constructor called.");
        this.numberOfLives=9;
        this.hasFur=true;
        this.hasTail=true;
    }
    public Cat(int lives, char size, boolean hasFur, boolean hasTail) {
        super(lives, size);
        this.hasFur = hasFur;
        this.hasTail = hasTail;
        System.out.println("Non-default cat constructor called.");
    }
    public boolean isHasFur() {
        return hasFur;
    }
    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }
    public boolean isHasTail() {
        return hasTail;
    }
    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }
    @Override
    public void cry() {
        System.out.println("The cat says, \"Meow\".");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return hasFur == cat.hasFur &&
                hasTail == cat.hasTail;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasFur, hasTail);
    }
    @Override
    public String toString() {
        return "Cat{" +
                "hasFur=" + hasFur +
                ", hasTail=" + hasTail +
                ", numberOfLives=" + numberOfLives +
                ", numberOfLegs=" + numberOfLegs +
                ", liveBirth=" + liveBirth +
                ", size=" + size +
                '}';
    }
}
