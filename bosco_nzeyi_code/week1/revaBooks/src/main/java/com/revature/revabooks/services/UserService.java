package com.revature.revabooks.services;

import com.revature.revabooks.models.User;
import com.sun.jdi.request.InvalidRequestStateException;

public class UserService {

    public void register(){
//        if(!isUserValid(newUser)) throw new InvalidRequestException();
    }
    public boolean isUserValid(User user){
        if(user == null) return false;




        return true;
    }
}
