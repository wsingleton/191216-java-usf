package com.revature.util;

import com.revature.models.Car;

import java.util.Comparator;

public class VinComparer implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getVin() > car2.getVin()) return 1;
        else if (car1.getVin() < car2.getVin()) return -1;
        return 0;
    }
}
