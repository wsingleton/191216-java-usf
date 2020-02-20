package com.revature.services;

import org.springframework.stereotype.Service;

@Service
public class SportMotivationService implements MotivationService{

    public SportMotivationService() {
        super();
        System.out.println("MotivationService no-args constructor invoked!");
    }

    @Override
    public String getMotivation() {
        return "Don't quit. Suffer now and live the rest of your life like a BOSS!";
    }
}
