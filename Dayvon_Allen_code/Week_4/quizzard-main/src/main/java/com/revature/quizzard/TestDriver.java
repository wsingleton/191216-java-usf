package com.revature.quizzard;

import com.revature.quizzard.models.Role;
import com.revature.quizzard.models.User;
import com.revature.quizzard.repos.UserRepository;


public class TestDriver {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        System.out.println("find all:");
        for (User u : repo.findAll()) System.out.println(u.toString());
        System.out.println("+----------------------------+");

        System.out.println("find by id:");
        System.out.println(repo.findById(1));
        System.out.println("+----------------------------+");

        System.out.println("find by username");
        System.out.println(repo.findUserByUsername("wsingleton"));
        System.out.println("+----------------------------+");

        System.out.println("find by valid credentials");
        System.out.println(repo.findUserByCredentials("wsingleton", "revature"));
        System.out.println("+----------------------------+");

        System.out.println("find by valid credentials");
        System.out.println(repo.findUserByCredentials("wsingleton", "badpw"));
        System.out.println("+----------------------------+");

        System.out.println("find by role");
        for (User u : repo.findUsersByRole(Role.PREMIUM_USER)) System.out.println(u.toString());
        System.out.println("+----------------------------+");


        System.out.println("Trying to add user: ");
        User newUser = new User(0, "newUser", "password", "John", "Doe", Role.BASIC_USER);
        if (!repo.findUserByUsername(newUser.getUsername()).isPresent()) {
            System.out.println("==========================Success!========================");
            System.out.println("before save: " + newUser);
            repo.save(newUser);
            System.out.println("after save: " + newUser);
            System.out.println("+----------------------------+");
        } else {
            System.out.println("==========================Failure!========================");
            System.out.println("User already Exists!");
            System.out.println("User in database: " + repo.findUserByUsername(newUser.getUsername()));
            System.out.println("+----------------------------+");
        }



        System.out.println("update user:");
        User updatedUser = newUser;
        updatedUser.setPassword("react!");
        System.out.println("update successful: " + repo.update(updatedUser));
        System.out.println("confirming update: " + repo.findUserByUsername(newUser.getUsername()));
        System.out.println("+----------------------------+");

        System.out.println("delete user not tested");


    }
}
