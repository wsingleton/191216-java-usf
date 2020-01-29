package com.revature.reimbursement_app;

import com.revature.reimbursement_app.models.Role;
import com.revature.reimbursement_app.models.User;
import com.revature.reimbursement_app.repos.UserRepository;

public class TestDriver {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        System.out.println("find all:");
        for (User u : repo.findAll()) System.out.println(u.toString());
        System.out.println("+-----------------------------------+");

        System.out.println("find by id:");
        System.out.println(repo.findById(1));
        System.out.println("+----------------------------+");

        System.out.println("find by username");
        System.out.println(repo.findUserByUsername("trubbert"));
        System.out.println("+----------------------------+");

        System.out.println("find by valid credentials");
        System.out.println(repo.findUserByCredentials("trubbert", "password"));
        System.out.println("+----------------------------+");

        System.out.println("find by valid credentials");
        System.out.println(repo.findUserByCredentials("wsingleton", "badpw"));
        System.out.println("+----------------------------+");

        System.out.println("find by role");
        for (User u : repo.findUsersByRole(Role.BASIC_USER)) System.out.println(u.toString());
        System.out.println("+----------------------------+");

//        System.out.println("add user: ");
//        User newUser = new User("bburke", "react", "Benjamin", "Burke", "burke@email.com");
//        System.out.println("before save: " + newUser);
//        repo.save(newUser);
//        System.out.println("after save: " + newUser);
//        System.out.println("+----------------------------+");



        System.out.println("update user:");
        User updatedUser = repo.findUserByUsername("bburke").get();
        updatedUser.setPassword("react!");
        System.out.println("update successful: " + repo.update(updatedUser));
        System.out.println("confirming update: " + repo.findUserByUsername("bburke"));
        System.out.println("+----------------------------+");

    }

}
