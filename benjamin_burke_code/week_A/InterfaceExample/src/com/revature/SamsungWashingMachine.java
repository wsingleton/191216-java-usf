package com.revature;

public class SamsungWashingMachine implements WashingMachine {

    @Override
    public void startButtonPressed() {
        System.out.println("The Samsung washing machine is now running.");
    }
}
