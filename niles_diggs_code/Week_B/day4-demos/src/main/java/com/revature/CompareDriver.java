package com.revature;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.util.VinComparer;

import java.util.ArrayList;
import java.util.Arrays;

public class CompareDriver {

    public static void main(String[] args) {
        /*
         * Comparable interface
         *
         * 		Java provides Comparable interface which should be implemented by any custom class if we want to use
         * 		Arrays or Collections sorting methods. Comparable interface has compareTo(T obj) method which is used
         * 		by sorting methods, you can check any Wrapper, String or Date class to confirm this. We should override
         * 		this method in such a way that it returns a negative integer, zero, or a positive integer if "this"
         * 		object is less than, equal to, or greater than the object passed as argument.
         */

        Box myBox = new Box(50.0, "brown");
        Box yourBox = new Box(45.5, "white");

        Box[] boxes = {myBox, new Box(3.5, "red"), yourBox};
        for (Box box : boxes) {
            System.out.println(box);
        }

        System.out.println("________0____________");

        Arrays.sort(boxes);

        for (Box box : boxes) {
            System.out.println(box);
        }

        System.out.println("___________________");


        /*
         * Comparator interface
         *
         * 		Comparator interface compare(Object o1, Object o2) method need to be implemented that takes two Object
         * 		argument, it should be implemented in such a way that it returns negative int if first argument is less
         * 		than the second one and returns zero if they are equal and positive int if first argument is greater
         * 		than second one.
         */

        Car myCar = new Car(123456, "Nissan", "Rouge", "grey");
        Car yourCar = new Car( 987654, "Nissan", "Murano", "maroon");

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(myCar);
        cars.add(yourCar);
        cars.add(new Car(892548, "Honda", "Accord", "Aqua"));
        cars.add(new Car(437934, "Lamborghini", "Murcielago", "black"));

        // sneak-peek at lambda expressions
        cars.forEach(car -> System.out.println(car));

//        cars.forEach(Car::toString); // shorter version, of the already short lambda expression

        System.out.println("+-----------------+");

        VinComparer vinComparer = new VinComparer();
        cars.sort(vinComparer);
        for (Car car : cars) System.out.println(car);

    }

}
