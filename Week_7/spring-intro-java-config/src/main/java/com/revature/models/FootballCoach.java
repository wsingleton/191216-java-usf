package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FootballCoach implements Coach, InitializingBean, DisposableBean {

    @Value("${coach.email}")
    private String email;

    @Value("Sad Name Team")
    private String team;

    private MotivationService motivationService;

    public FootballCoach() {
        super();
        System.out.println("FootballCoach no-args constructor invoked!");
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
    public void setMotivationService(MotivationService sportMotivationService) {
        this.motivationService = sportMotivationService;
    }

    public void customInit() {
        System.out.println("FootballCoach.customInit invoked!");
    }

    public void customDestroy() {
        System.out.println("FootballCoach.customDestroy invoked!");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("FootballCoach.postConstruct invoked!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("FootballCoach.preDestroy invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Do suicide runs to 40, 50, 60, 80, 100 yard lines";
    }

    @Override
    public String getMotivation() {
        return "The football coach says: " + motivationService.getMotivation();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("FootballCoach.destroy invoked!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FootballCoach.afterPropertiesSet invoked!");
    }
}
