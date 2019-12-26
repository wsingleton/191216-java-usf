package com.revature;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.util.YearComparator;

import java.util.ArrayList;
import java.util.Arrays;

public class CompareDriver {
    public static void main(String[] args) {
        Box yourBox = new Box(50.0, "brown");
        Box myBox = new Box(45.5, "grey");
        Box[] boxes = {yourBox, new Box(8.2, "purple"), myBox};
        for (Box box : boxes) {
            System.out.println(box);
        }
        System.out.println("+------------==========================------------+");
        Arrays.sort(boxes);
        for (Box box : boxes) {
            System.out.println(box);
        }
        System.out.println("+------------==========================------------+");
        Car firstCar = new Car(2001, "Nissan", "Pathfinder", "Silver");
        Car current = new Car(2009, "Nissan", "Murano", "maroon");

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(firstCar);
        cars.add(current);
        cars.add(new Car(2016, "Scion", "IQ", "orange"));
        cars.add(new Car(2012, "Dodge", "Caravan", "blue"));

        cars.forEach(car -> System.out.println(car));
        System.out.println("+------------==========================------------+");
        YearComparator yearCompare = new YearComparator();
        cars.sort(yearCompare);
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
