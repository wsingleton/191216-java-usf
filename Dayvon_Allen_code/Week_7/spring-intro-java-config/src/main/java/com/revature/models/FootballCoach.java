package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FootballCoach implements Coach {

    @Value("${email}")
    private String email;

    @Value("Sad Name Team")
    private String team;

    private MotivationService motivationSevice;

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

    public MotivationService getMotivationSevice() {
        return motivationSevice;
    }

    //setter based dependency injection.
    public void setMotivationSevice(MotivationService motivationSevice) {
        this.motivationSevice = motivationSevice;
    }

    public void customInit() {
        System.out.println("custom init invoked");
    }

    public void customDestroy() {
        System.out.println("custom destroy invoked");

    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Post contructor");
    }

    @PreDestroy
    public  void preDestroy(){
        System.out.println("pre construct");
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
