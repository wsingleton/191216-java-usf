package com.revature.models;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach {
    private MotivationService motivationSevice;

    public TrackCoach() {
        System.out.println("track Coach, noargs constructor");
    }

    //constructor level dependency injection
    public  TrackCoach(MotivationService sevice){
        this.motivationSevice = sevice;
        System.out.println("track coach parameterized");
    }

    @Override
    public String getDailyWorkout() {
        return "Run 5 min 5k";
    }

    @Override
    public String getMotivated() {
        return "The track coach says" + motivationSevice.getMotivated();
    }
}
