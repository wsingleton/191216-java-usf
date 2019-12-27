package com.revature;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.util.VinComparer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareDriver {
    public static void main(String... args){
        Box myBox = new Box( "brown",50.0);
        Box yourBox = new Box("white",45.5);

        Box[] boxes = {myBox, new Box( "red",3.5), yourBox};
for (Box box : boxes){
        System.out.println(box);}
        System.out.println("+----------------------+");
Arrays.sort(boxes);
for(Box box : boxes){
    System.out.println(box);
}
        System.out.println("+-------------------------+");

Car myCar = new Car(123456, "Nissan", "Rogue", "grey");
        Car yourCar = new Car(987456, "Nissan", "murano", "maroon");
ArrayList<Car> cars = new ArrayList<>();
cars.add(myCar);
cars.add(yourCar);
cars.add(new Car(7892345, "Honda", "Accord", "silver" ));
cars.add(new Car(9876, "Dodge", "Charger Hellcat", "Orange"));
//sneak peek at lambda expression
        cars.forEach(car -> System.out.println(car));
        System.out.println("+--------------------------+");
        VinComparer vinComparer = new VinComparer();
        cars.sort(vinComparer);
        for(Car car: cars) System.out.println(car);

    }
}
