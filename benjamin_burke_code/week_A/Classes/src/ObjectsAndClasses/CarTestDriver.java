package ObjectsAndClasses;

public class CarTestDriver {

    public static void main(String[] args){
        //Now we create two different cars which means 2 new objects
        //Create new Audi Car Object
        Car audi = new Car("Audi");
        //Create new Nissan Car Object
        Car nissan = new Car("Nissan");

        //print current speed of Audi
        audi.printCurrentSpeed();

        //call the accelerate method twice on audi!
        audi.accelerate();
        audi.accelerate();

        //call the accelerate on nissan
        nissan.accelerate();

        //print the current speed of both cars
        audi.printCurrentSpeed();
        nissan.printCurrentSpeed();
    }
}
