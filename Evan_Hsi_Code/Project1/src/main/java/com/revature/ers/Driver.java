package com.revature.ers;

import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.UserService;

public class Driver {

    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        UserService serv = new UserService(repo);

        System.out.println("find all: ");
        System.out.println(repo.findAll());

        System.out.println("find by id");
        System.out.println(repo.findById(1));

        System.out.println("find by username");
        System.out.println(repo.findUserByUsername("ehsi"));

        System.out.println("find by credentials");
        System.out.println(repo.findUserByCredentials("ehsi", "password"));

        System.out.println("find by invalid credentials");
        System.out.println(repo.findUserByCredentials("ehsi", "asdf"));

        System.out.println("find by creds service");
        System.out.println(serv.authenticate("ehsi", "password"));
    }
}
