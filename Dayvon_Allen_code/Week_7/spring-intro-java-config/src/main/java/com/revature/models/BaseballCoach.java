package com.revature.models;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

    private MotivationService motivationSevice;
    public BaseballCoach() {
        System.out.println("Baseball Coach, noargs constructor");
    }

    public  BaseballCoach(MotivationService sevice){
        this.motivationSevice = sevice;
        System.out.println("baseball coach parameterized");
    }
    @Override
    public String getDailyWorkout() {
        return "Today's workout: spend 30 minutes on batting practice.";
    }

    @Override
    public String getMotivated() {
        return "Baseball coach says!!! " + motivationSevice.getMotivated();
    }

}

