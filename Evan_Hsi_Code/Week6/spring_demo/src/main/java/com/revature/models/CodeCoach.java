package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CodeCoach implements Coach {

    private MotivationService motivationService;

    public CodeCoach() {
        super();
        System.out.println("CodeCoach no-args constructor invoked!");
    }

    @Autowired
    public CodeCoach(MotivationService service) {
        super();
        this.motivationService = service;
        System.out.println("CodeCoach parameterized constructor invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Code";
    }

    @Override
    public String getMotivation() {
        return "The code coach says: " + motivationService.getMotivation();
    }

}
