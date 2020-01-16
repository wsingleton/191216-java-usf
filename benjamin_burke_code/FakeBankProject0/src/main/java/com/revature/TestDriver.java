package com.revature;

import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Set;

public class TestDriver {
    public static void main(String[] args) {

        Connection conn = ConnectionFactory.getInstance().getConnection();

        if(conn==null) System.out.println("Connection failed");

        UserRepository testRepo = new UserRepository();
        Set<User> didItwork = testRepo.findAll();
        didItwork.forEach(user -> System.out.println(user));
    }
}