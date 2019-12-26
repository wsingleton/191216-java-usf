package com.revature.models;

import java.util.Objects;

public class Car {
    private int vin;
    private String make;
    private String model;
    private String color;

    public Car(int vin, String make, String model, String color) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getVin() == car.getVin() &&
                getMake().equals(car.getMake()) &&
                getModel().equals(car.getModel()) &&
                getColor().equals(car.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin(), getMake(), getModel(), getColor());
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin=" + vin +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
