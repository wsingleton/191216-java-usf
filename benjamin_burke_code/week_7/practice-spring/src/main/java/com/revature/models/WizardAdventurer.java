package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;

public class WizardAdventurer implements Adventurer {

    private MotivationService motivationService;

    public WizardAdventurer(){
        super();
        System.out.println("WizardAdeventurer no-args is called!");
    }

    @Autowired
    public WizardAdventurer(MotivationService service){
        super();
        this.motivationService = service;
        System.out.println();
    }

    @Override
    public String getMightyPower() {
        return "You shall be zapped!";
    }

    @Override
    public String getMotivation() {
        return "You shall not pass!";
    }
}
