package com.revature.models;

import java.util.Objects;

public class Car {

    private int vin;
    private String make;
    private String model;
    private String colour;

    public Car(int vin, String make, String model, String colour) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.colour = colour;
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return vin == car.vin &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model) &&
                Objects.equals(colour, car.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, make, model, colour);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin=" + vin +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
