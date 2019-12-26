package com.revature.util;

import com.revature.models.Car;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getYear()>o2.getYear()) {
            return 1;
        }
        else if (o1.getYear()<o2.getYear()) {
            return -1;
        }
        return 0;
    }
}
