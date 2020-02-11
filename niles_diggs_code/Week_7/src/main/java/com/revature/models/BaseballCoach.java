package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component// default name is baseballCoach and can be overridden here
public class BaseballCoach implements Coach {

    //private MotivationService motivationService = new MotivationService(); - this is tight coupling, if you change class B class A breaks

    private MotivationService motivationService;



    public BaseballCoach() {
        super();
        System.out.println("BaseballCoach no-args constructor invoked");
    }

    // constructor based dependency injection
    @Autowired //will be automatically able to detect this by both type and by name
    public BaseballCoach(MotivationService service) {
        super();
        this.motivationService = service;
        System.out.println("BaseballCoach parameterized constructor invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

    @Override
    public String getMotivation() {
        return "The baseball coach says" + motivationService.getMotivation();
    }
}
