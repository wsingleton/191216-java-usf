package com.revature.models;

public interface InterfaceB extends InterfaceA{
    void getYourTowel();
    default void soLong() {
        System.out.println("So long and thanks for all the fish!");
    }
}
