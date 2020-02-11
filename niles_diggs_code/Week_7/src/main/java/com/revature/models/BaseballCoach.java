package com.revature.models;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

    //private MotivationService motivationService = new MotivationService(); - this is tight coupling, if you change class B class A breaks

    private MotivationService motivationService;


    // constructor based dependency injection
    public BaseballCoach() {
        super();
        System.out.println("BaseballCoach no-args constructor invoked");
    }

    public BaseballCoach(MotivationService service) {
        super();
        this.motivationService = service;
        System.out.println("BaseballCoach parameterized constructor invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

    @Override
    public String getMotivation() {
        return "The baseball coach says" + motivationService.getMotivation();
    }
}
