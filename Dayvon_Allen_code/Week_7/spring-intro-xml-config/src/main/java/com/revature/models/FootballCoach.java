package com.revature.models;

import com.revature.services.MotivationSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myFootballCoach")
public class FootballCoach implements Coach {

    @Value("${email}")
    private String email;
    @Value("Sad Name Team")
    private String team;

    private MotivationSevice motivationSevice;


    public FootballCoach() {
        System.out.println("football Coach, noargs constructor");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public MotivationSevice getMotivationSevice() {
        return motivationSevice;
    }

    //setter based dependency injection.
    @Autowired
    public void setMotivationSevice(MotivationSevice motivationSevice) {
        this.motivationSevice = motivationSevice;
    }

    public void customInit() {
        System.out.println("custom init invoked");
    }

    public void customDestroy() {
        System.out.println("custom destroy invoked");

    }

    @Override
    public String getDailyWorkout() {
        return "Do suicide runs to 40,50";
    }

    @Override
    public String getMotivated() {
        return "The football coach says: " + motivationSevice.getMotivated();
    }
}
