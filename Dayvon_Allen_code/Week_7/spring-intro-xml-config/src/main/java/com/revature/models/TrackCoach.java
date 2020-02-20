package com.revature.models;

import com.revature.services.MotivationSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    private MotivationSevice motivationSevice;

    public TrackCoach() {
        System.out.println("track Coach, noargs constructor");
    }

    //constructor level dependency injection
    @Autowired
    public  TrackCoach(MotivationSevice sevice){
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
