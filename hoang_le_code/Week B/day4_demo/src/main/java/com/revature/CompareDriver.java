package com.revature;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.util.VinComparer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareDriver {

    public static void main(String args[]){

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

        Box[] boxes = {myBox,new Box(3.5, "red"), yourBox};

        for (Box box : boxes){
            System.out.println(box);
        }

        System.out.println("+------------------------------+");

        Arrays.sort(boxes);


        Car myCar = new Car(123,"NS","rogue","silver");
        Car yourCar = new Car(112323,"NsS","aaarogue","sssssilver");
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(myCar);
        cars.add(yourCar);
        cars.add(new Car(12321,"dasda","asdasd","asdas"));
        cars.add(new Car(124444321,"dasdsadasda","asdqweqweasd","aseqeweqdas"));

        cars.forEach(car -> System.out.println(car));
        // cars.forEach(Car::toString); shorter version




        System.out.println("----------------");
        VinComparer vinComparer = new VinComparer();
        cars.sort(vinComparer);
        for(Car car :cars) System.out.println(car);


    }
}
