package ObjectsAndClasses;

public class Car {

    //car-object states stored into fields
    int currentSpeed;
    String name;

    //constructor
    public Car(String name) {
        this.name=name;
    }


    //behavior of the cars shown in methods
    public void accelerate() {
        //lets add 20 miles per hour to the current speed
        currentSpeed = currentSpeed + 10;
    }

    public void park(){
        //lets set current speed to 0 since car is parked
        currentSpeed = 0;

    }

    public void printCurrentSpeed(){
        //We want to display the current speed of the car
        //Whether its parked or moving
        System.out.println("The current speed of " + name + "is " +
        currentSpeed + "mph.");

    }
}
