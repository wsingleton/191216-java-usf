package com.revature.models;

import java.util.Objects;

public class Box implements Comparable<Box> {
    private double volume;
    private String colour;

    public Box(double volume, String colour) {
        this.volume = volume;
        this.colour = colour;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
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
        Box box = (Box) o;
        return Double.compare(box.volume, volume) == 0 &&
                Objects.equals(colour, box.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, colour);
    }

    @Override
    public String toString() {
        return "Box{" +
                "volume=" + volume +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public int compareTo(Box other) {
        if (this.volume>other.volume) {
            return 1;
        }
        else if (this.volume<other.volume) {
            return -1;
        }
        return 0;
    }
}
