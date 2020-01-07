package com.revature.mockbank;

/*
Main method class to initiate the application
 */

import com.revature.mockbank.models.AccountType;
import com.revature.mockbank.models.Role;
import com.revature.mockbank.models.User;
import com.revature.mockbank.repositories.UserRepo;

import java.util.Optional;

public class AppDriver {

    public static void main (String[] args){
        System.out.println("mockBank app initializing .............");
        System.out.println(Role.CLIENT);
        System.out.println(AccountType.CHECKING);

        // create a user for testing purpose.
        User u = new User(1, "Bosco", "Nzeyi", "nebo", "passcode", Role.CLIENT);
        // put the user into the user repo
        UserRepo repo = new UserRepo();
        repo.save(u);
//        Set<User> s = repo.findAll();
//        for(User i: s){
//            System.out.println(i);
//        }
        Optional get = repo.findById(3);
        System.out.println(get);


    }
}
