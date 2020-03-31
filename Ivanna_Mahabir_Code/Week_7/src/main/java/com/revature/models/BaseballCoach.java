package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCoach")
@Scope("prototype")
public class BaseballCoach implements Coach {

    private MotivationService motivationService;

    public BaseballCoach(){
        super();
        System.out.println("Baseball coach no-args constructor invoked");
    }

    @Autowired
    public BaseballCoach(MotivationService service){
        super();
        this.motivationService = service;
        System.out.println("BaseballCoach parameterized constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Today's workout: Spend 30min on batting practice.";
    }

    @Override
    public String getMotivation() {
        return "The basaball coach says" + motivationService.getMotivation();
    }
}
