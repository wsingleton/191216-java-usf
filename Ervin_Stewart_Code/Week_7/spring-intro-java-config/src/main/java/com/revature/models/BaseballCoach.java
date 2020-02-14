package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("myCoach")
public class BaseballCoach implements Coach {

    private MotivationService motivationService = new MotivationService();

    public BaseballCoach(){
        super();
        System.out.println("baseball coach no argues constructor invoked");
    }

    public BaseballCoach(MotivationService service){
        super();
        this.motivationService = service;
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Spend 30 minutes on batting practice!";
    }

    @Override
    public String getMotivation() {
        return "this Baseball coach says " + motivationService.getMotivation();
    }
}
