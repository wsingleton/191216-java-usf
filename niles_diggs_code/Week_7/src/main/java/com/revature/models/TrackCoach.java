package com.revature.models;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach {

    private MotivationService motivationService;

    public TrackCoach() {
        super();
        System.out.println("BaseballCoach no-args constructor invoked");
    }

    public TrackCoach(MotivationService service) {
        super();
        this.motivationService = service;
        System.out.println("BaseballCoach parameterized constructor invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout is to run and 30-minute 5k";
    }

    @Override
    public String getMotivation() {
        return null;
    }
}
