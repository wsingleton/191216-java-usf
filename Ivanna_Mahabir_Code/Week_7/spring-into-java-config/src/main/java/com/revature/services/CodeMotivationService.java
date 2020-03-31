package com.revature.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("code")
public class CodeMotivationService implements MotivationService{

    public CodeMotivationService(){
        super();
        System.out.println("CodeMotivation no-args constructor invoked");
    }


    public String getMotivation() {

        return "Don't Quit. Suffer now and code the rest of your life like a boss!";
    }
}
