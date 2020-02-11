package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Value("${coach.email}")
    private String email;

    @Value("Sad Name Team")
    private String team;

    // putting the AutoWired annotation here is called field level injection, causes tightly coupling to the container, do not do this
    private MotivationService motivationService;

    public FootballCoach() {
        super();
        System.out.println("FootballCoach no-args constructor invoked");
    }

    public FootballCoach(MotivationService service) {
        super();
        this.motivationService = service;
        System.out.println("FootballCoach parameterized constructor invoked!");
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

    public MotivationService getMotivationService() {
        return motivationService;
    }

    // setter-based dependency injection
    @Autowired
    public void setMotivationService(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    public void customInit() {
        System.out.println("FootballCoach.customInit invoked");

    }

    public void customDestroy() {
        System.out.println("FootballCoach.customDestroy invoked");

    }

    @Override
    public String getDailyWorkout() {
        return "Do full field sprints";
    }

    @Override
    public String getMotivation() {
        return "The FootballCoach says" + motivationService.getMotivation();
    }
}
