package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CodeCoach implements Coach {

    private MotivationService motivationService;

    public CodeCoach(){
        super();
        System.out.println("Track coach no-args constructor invoked");
    }

    @Autowired
    public CodeCoach(@Qualifier("code") MotivationService service){
        super();
        this.motivationService = service;
        System.out.println("TrackCoach parameterized constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "run a 5k";
    }

    @Override
    public String getMotivation() {
        return "The track coach says " + motivationService.getMotivation();
    }
}
