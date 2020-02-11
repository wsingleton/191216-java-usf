package com.revature.models;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

    private MotivationService motivationService;

    public BaseballCoach() {
        super();
        System.out.println("BaseballCoach no args constructor invoked!");
    }

    public BaseballCoach(MotivationService service) {
        super();
        this.motivationService = service;
        System.out.println("BaseballCoach parameterized constructor invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Spend 30 minutes on batting practice.";
    }

    @Override
    public String getMotivation() {
        return "The baseball coach says: " + motivationService.getMotivation();
    }

}
