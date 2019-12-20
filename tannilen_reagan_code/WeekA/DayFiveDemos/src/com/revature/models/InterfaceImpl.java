package com.revature.models;

public class InterfaceImpl implements InterfaceA,InterfaceB{
    @Override
    public void getYourTowel() {
        System.out.println("Don't leave home without your towel.");
    }
}
