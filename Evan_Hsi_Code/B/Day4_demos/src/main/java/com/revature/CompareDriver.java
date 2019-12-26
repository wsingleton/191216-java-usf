package com.revature;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.models.VinComparer;

import java.util.ArrayList;
import java.util.Arrays;

public class CompareDriver {

    public static void main(String[] args) {
        Box myBox = new Box(50.0, "brown");
        Box yourBox = new Box(45.5, "white");

        Box[] boxes = {myBox, new Box(3.5, "red"), yourBox};
        for(Box box : boxes) {
            System.out.println(box);
        }

        System.out.println("+----------------------------");

        Arrays.sort(boxes);

        for(Box box : boxes) {
            System.out.println(box);
        }

        System.out.println("+----------------");

        Car myCar = new Car(123456, "Nissan", "Rogue", "grey");
        Car yourCar = new Car(654321, "Nissan", "Murano", "maroon");

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(myCar);
        cars.add(yourCar);
        cars.add(new Car(73957, "Honda", "Accord", "silver"));
        cars.add(new Car(231, "Dodge", "Caravan", "orange"));
        cars.forEach(Car::toString);

        VinComparer vinComparer = new VinComparer();
        cars.sort(vinComparer);
        cars.forEach(car -> System.out.println(car));

    }
}
