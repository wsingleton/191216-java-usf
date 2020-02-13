package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;

public class KnightAdventurer implements Adventurer {

    private MotivationService motivationService;


    public KnightAdventurer(){
        super();
        System.out.println("KnightAdventurer no-args constructor involved");
    }

    //now we do a constructor based dependency injection
    @Autowired
    public KnightAdventurer(MotivationService service){
        super();
        this.motivationService = service;
        System.out.println("KnightAdventurer parameterized constructor invoked!");
    }

    @Override
    public String getMightyPower() {
        return "Fear my mighty sword!";
    }

    @Override
    public String getMotivation() {
        return "We can do it comrades!";
    }
}
