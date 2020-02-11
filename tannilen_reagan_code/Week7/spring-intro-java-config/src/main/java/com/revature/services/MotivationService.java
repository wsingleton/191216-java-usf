package com.revature.services;

import org.springframework.stereotype.Service;

@Service("motivation")
public class MotivationService {
    public MotivationService() {
        super();
        System.out.println("MotivationService no-args invoked");
    }

    public String getMotivation() {
        return "Don't quit.  Suffer now, and code the rest of your life like a boss.";
    }
}
