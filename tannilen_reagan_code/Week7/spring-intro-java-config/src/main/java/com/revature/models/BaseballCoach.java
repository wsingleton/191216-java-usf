package com.revature.models;

import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("coach")
@Scope("prototype")
public class BaseballCoach implements Coach {
    private MotivationService motivationService;
    public BaseballCoach() {
        super();
        System.out.println("BaseballCoach no-args invoked");
    }
    @Autowired
    public BaseballCoach(SportMotivationService service) {
        super();
        this.motivationService=service;
        System.out.println("BaseballCoach parameterized invoked");
    }
    @Override
    public String getDailyWorkout() {
        return "Today's workout: 30 minutes of bat practice.";
    }

    @Override
    public String getMotivation() {
        return "The baseball coach says, \""+motivationService.getMotivation()+"\"";
    }
}
