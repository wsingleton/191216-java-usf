package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CodeCoach implements Coach {
    private MotivationService motivationService;
    public CodeCoach() {
        super();
        System.out.println("CodeCoach no-args invoked");
    }
    @Autowired
    public CodeCoach(@Qualifier("code") MotivationService service) {
        super();
        this.motivationService=service;
        System.out.println("CodeCoach parameterized invoked");
    }
    @Override
    public String getDailyWorkout() {
        return "Today's workout: Debug bad code.";
    }

    @Override
    public String getMotivation() {
        return "The code coach says, \""+motivationService.getMotivation()+"\"";
    }
}
