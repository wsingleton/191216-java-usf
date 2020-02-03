package com.revature.project1;

import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Role;
import com.revature.project1.models.User;
import com.revature.project1.repos.ReimbursementRepository;
import com.revature.project1.repos.UserRepository;

public class TestDriver {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        ReimbursementRepository reimbrepo = new ReimbursementRepository();

        System.out.println("find all:");
        for (User u : repo.findAll()) System.out.println(u.toString());
        System.out.println("find reimbursement:");
        for (Reimbursement r : reimbrepo.findAll()) System.out.println(r.toString());
        System.out.println("+----------------------------+");

        System.out.println("find by id:");
        System.out.println(repo.findById(1));
        System.out.println("find reimb by id: ");
        System.out.println(reimbrepo.findById(21));
        System.out.println("+----------------------------+");

        System.out.println("find by username");
        System.out.println(repo.findUserByUsername("benji"));
        System.out.println("find reimbursement by username");
        System.out.println(reimbrepo.findByUserId(41));
        System.out.println("+----------------------------+");

        System.out.println("find by valid credentials");
        System.out.println(repo.findUserByCredentials("wsingleton", "bruce"));
        System.out.println("+----------------------------+");

        System.out.println("find by valid credentials");
        System.out.println(repo.findUserByCredentials("benji", "bruce"));
        System.out.println("+----------------------------+");

        System.out.println("find by role");
        for (User u : repo.findUsersByRole(Role.EMPLOYEE)) System.out.println(u.toString());
        System.out.println("+----------------------------+");

        System.out.println("add user: ");
        User newUser = new User(0, "abatson", "react", "Alec", "Batson", Role.EMPLOYEE);
        System.out.println("before save: " + newUser);
        repo.save(newUser);
        System.out.println("after save: " + newUser);
        System.out.println("+----------------------------+");

        System.out.println("update user:");
        User updatedUser = newUser;
        updatedUser.setPassword("react!");
        System.out.println("update successful: " + repo.update(updatedUser));
        System.out.println("confirming update: " + repo.findUserByUsername("abatson"));
        System.out.println("+----------------------------+");

        System.out.println("delete user not tested");


    }
}