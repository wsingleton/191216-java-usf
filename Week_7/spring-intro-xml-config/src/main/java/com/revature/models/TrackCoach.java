package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    private MotivationService motivationService;

    public TrackCoach() {
        super();
        System.out.println("TrackCoach no-args constructor invoked!");
    }

    @Autowired
    public TrackCoach(MotivationService service) {
        super();
        this.motivationService = service;
        System.out.println("TrackCoach parameterized constructor invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Run a 30-minute 5K";
    }

    @Override
    public String getMotivation() {
        return "The track coach says: " + motivationService.getMotivation();
    }

}
