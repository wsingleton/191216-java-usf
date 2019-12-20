package com.revature.models;

public interface InterfaceA {
    int ANSWER_TO_LIFE_THE_UNIVERSE_AND_EVERYTHING=42;
    void getYourTowel();
    default void soLong() {
        System.out.println("Thanks for all the fish!");
    }
}
