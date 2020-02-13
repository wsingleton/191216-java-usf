package com.revature.models;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach {

    private MotivationService motivationService;

    public TrackCoach(){
        super();
        System.out.println("The Trackcoach no-args constructor invoked!");
    }

    public TrackCoach(MotivationService service){
        super();
        this.motivationService = service;
        System.out.println("TrackCoach parameterized constructor invoked!");
    }


    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getMotivation() {
        return null;
    }
}
