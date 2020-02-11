package com.revature.models;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class FootballCoach {

    @Value("${coach.vaue}") // value injection from the properties

    @Value("Sad Team Name")


    @PostConstruct
    public void postConstruct() {
        System.out.println("FootballCoach.postConstruct invoked!");

    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("FootballCoach.preDestroy invoked!");
    }
}
