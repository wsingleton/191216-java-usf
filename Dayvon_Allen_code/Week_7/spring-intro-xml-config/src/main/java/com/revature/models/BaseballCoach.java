package com.revature.models;

import com.revature.services.MotivationSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("myCoach")
public class BaseballCoach implements Coach {
    private MotivationSevice motivationSevice;
    public BaseballCoach() {
        System.out.println("Baseball Coach, noargs constructor");
    }

    @Autowired
    public  BaseballCoach(MotivationSevice sevice){
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
