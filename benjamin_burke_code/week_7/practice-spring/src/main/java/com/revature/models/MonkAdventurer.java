package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;

public class MonkAdventurer implements Adventurer {

    private String weapon;

    private String name;

    private MotivationService motivationService;

    public MonkAdventurer(){
        super();
        System.out.println("MonkAdventurer no args is invoked!");
    }

    //Add GETTER and SETTER


    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MotivationService getMotivationService() {
        return motivationService;
    }

    //autowire since this is  setter-based dependency
    @Autowired
    public void setMotivationService(MotivationService motivationService) {
        this.motivationService = motivationService;

    }

    public void customInit(){
        System.out.println("MonkAdventurer.customInit invoked!");
    }

    public void customDestroy(){
        System.out.println("MonkAdventurer.customDestroy invoked!");
    }


    @Override
    public String getMightyPower() {
        return "Fear the power of balance and tranquility";
    }

    @Override
    public String getMotivation() {
        return "We are all blessed and all living!";
    }
}
