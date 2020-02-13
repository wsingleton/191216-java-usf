package com.revature.models;

public class BaseballCoach implements Coach {

    public BaseballCoach(){
        super();
        System.out.println("BaseballCoach no-args constructor invoked!");
    }

    public BaseballCoach(){
        super();
        this.motivationService = service;
    }

    @Override
    public String getDailylWorkout() {
        return null;
    }

    @Override
    public String getMotivation() {
        return null;
    }
}
