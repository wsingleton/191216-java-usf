package com.revature.services;

public class SportMotivationService implements MotivationService {

    public SportMotivationService() {
        super();
        System.out.println("SportMotivationService no-args constructor invoked!");
    }

    public String getMotivation() {
        return "Don't quit. Suffer now and live the rest of your life like a champion!";
    }
}
