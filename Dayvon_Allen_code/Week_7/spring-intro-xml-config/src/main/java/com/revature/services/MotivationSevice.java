package com.revature.services;

import org.springframework.stereotype.Service;

@Service("myMotivationService")
public class MotivationSevice {

    public MotivationSevice() {
        System.out.println("Motivation service no args.");
    }

    public String getMotivated(){
        return "Don't quit. Suffer now and code the rest of your life like a boss.";
    }
}
