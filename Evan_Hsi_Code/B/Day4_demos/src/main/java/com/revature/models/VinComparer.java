package com.revature.models;

import java.util.Comparator;

public class VinComparer implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if(o1.getVin() > o2.getVin()) return 1;
        else if(o1.getVin() < o2.getVin()) return -1;
        return 0;
    }
}
