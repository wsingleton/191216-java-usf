package com.revature.model;

import java.util.Objects;

public class cat extends Animal {


    private int numberOfLives; // Animal.numberOfLives is shadowed by this declaration
    private String bread;
    private  String brand;
    private boolean hasfur;

    public cat(){
        System.out.println(" cat contructor called" +
                "asd");

        this.numberOfLife = 9;
        this.bread= "hello";
        this.hasfur = true;
    }

    public cat(int i, String bbbb, boolean hasfur) {
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public cat(String bread, String brand, boolean hasfur) {
        this.bread = bread;
        this.brand = brand;
        this.hasfur = hasfur;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isHasfur() {
        return hasfur;
    }

    public void setHasfur(boolean hasfur) {
        this.hasfur = hasfur;
    }

    @Override
    public void makeSound() {
        System.out.println("moew");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        cat cat = (cat) o;
        return hasfur == cat.hasfur &&
                Objects.equals(bread, cat.bread) &&
                Objects.equals(brand, cat.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bread, brand, hasfur);
    }

    @Override
    public String toString() {
        return "cat{" +
                "bread='" + bread + '\'' +
                ", brand='" + brand + '\'' +
                ", hasfur=" + hasfur +
                '}';
    }
}
