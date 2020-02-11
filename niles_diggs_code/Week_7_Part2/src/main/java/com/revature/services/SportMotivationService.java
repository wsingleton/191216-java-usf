package com.revature.services;

import org.springframework.stereotype.Service;


@Service
public class SportMotivationService implements MotivationService {

    public SportMotivationService() {
        super();
        System.out.println("What ever the thing he put here was");
    }
    @Override
    public String getMotivation() {
        return "Don't quit. Suffer now and live the rest of your life like a champion";
    }
}
