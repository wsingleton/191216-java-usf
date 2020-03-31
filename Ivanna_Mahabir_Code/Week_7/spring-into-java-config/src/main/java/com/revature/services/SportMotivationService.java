package com.revature.services;

import org.springframework.stereotype.Service;

@Service
public class SportMotivationService implements MotivationService {

    public SportMotivationService(){
        super();
        System.out.println("SportMotivationService no-args constructor invoked!");
    }



    public String getMotivation() {
        return "Sport Motivation";
    }
}
