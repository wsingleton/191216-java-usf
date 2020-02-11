package com.revature.models;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach {
    private MotivationService motivationService;
    public TrackCoach() {
        super();
        System.out.println("TrackCoach no-args invoked");
    }
    public TrackCoach(MotivationService service) {
        super();
        this.motivationService=service;
        System.out.println("TrackCoach parameterized invoked");
    }
    @Override
    public String getDailyWorkout() {
        return "Today's workout: run a 30 minute 5k.";
    }

    @Override
    public String getMotivation() {
        return "The track coach says, \""+motivationService.getMotivation()+"\"";
    }
}
