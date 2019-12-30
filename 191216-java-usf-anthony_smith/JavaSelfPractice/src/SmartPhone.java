

//SmartPhone is the class
class SmartPhone {

    // instance variable
    boolean isOn = true;

    // instance method
    void turnOff() {
        isOn = false;
    }

    // instance method 2
    void turnOn() {
        isOn = true;
    }

    // instance method 3
    void displayPhoneStatus() {
        System.out.println("Is the phone on : " + isOn);
    }
}

class ClassObjectExamples{
    public static void main (String[] args){

        // constructor used to make new objects
        SmartPhone iPhone = new SmartPhone();
        SmartPhone Galaxy = new SmartPhone();

        // objects calling instance methods
        iPhone.turnOff();
        Galaxy.turnOn();

        // objects calling instance methods
        iPhone.displayPhoneStatus();
        Galaxy.displayPhoneStatus();
    }

}