package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Value("${coach.email}")
    private String email;

    @Value("Buhlakays")
    private String team;
    private MotivationService motivationService;

    public FootballCoach() {
        super();
        System.out.println("FootballCoach no args constructor invoked!");
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

    @Autowired
    public void setMotivationService(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    public void customInit() {
        System.out.println("FootballCoach.customInit invoked!");
    }

    public void customDestroy() {
        System.out.println("FootballCoach.customDestroy invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Do suicides to 40, 50, 60, 80, and 100 yard lines";
    }

    @Override
    public String getMotivation() {
        return "The football coach says: " + motivationService.getMotivation();
    }
}
