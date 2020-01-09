package com.revature.revabooks;

import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Set;

public class TestDriver {

    public static void main(String[] args) {

        Connection conn = ConnectionFactory.getInstance().getConnection();

        if(conn == null) System.out.println("Connection Failed");
        else System.out.println("Connection Successful!");

        UserRepository testRepo = new UserRepository();
        Set<User> did = testRepo.findAll();
        did.forEach(user -> System.out.println(user));
    }
}
