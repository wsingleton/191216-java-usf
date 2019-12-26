package com.revature;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.util.VinComparator;

import java.util.ArrayList;
import java.util.Arrays;

public class CompareDriver {

    public static void main(String[] args) {
        Box myBox = new Box(50.0, "brown");
        Box yourBox = new Box(45.5, "white");

        Box[] boxes = {myBox, new Box(3.5, "red"), yourBox};

        for (Box box : boxes){
            System.out.println(box);
        }
        System.out.println("+-----------------------------------+");
        Arrays.sort(boxes);

        for (Box box : boxes){
            System.out.println(box);
        }

        System.out.println("+----------------------------------------+");
        Car myCar = new Car(12345, "Nissan ", "Rogue","gray");
        Car yourCar = new Car(98764, "Nissan ", "Murano","maroon");

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(myCar);
        cars.add(yourCar);
        cars.add(new Car(768599, "Honda", "Accord", "silver"));
        cars.add(new Car(9876, "Dodge", "Caravan", "orange"));

        cars.forEach(car -> System.out.println(car));
//        cars.forEach(Car::toString); // shorter version of lambda expression
        System.out.println("+----------------------------------------+");

        VinComparator newVinComparator = new VinComparator();
        cars.sort(newVinComparator);
        for (Car c : cars
             ) {
            System.out.println(c);
        }



    }
}
