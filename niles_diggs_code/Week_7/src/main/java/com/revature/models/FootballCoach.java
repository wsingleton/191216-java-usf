package com.revature.models;

import com.revature.services.MotivationService;

public class FootballCoach implements Coach {

    private String email;
    private String team;

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
