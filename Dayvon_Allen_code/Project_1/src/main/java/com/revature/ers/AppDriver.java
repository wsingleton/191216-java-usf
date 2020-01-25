package com.revature.ers;

import com.revature.ers.models.Role;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.util.ConnectionFactory;

import java.sql.Connection;

public class AppDriver {

    public static void main(String[] args) {
//        Connection conn = ConnectionFactory.getInstance().getConnection();
//        try {
//            if (conn != null) {
//                System.out.println("Connection Established");
//            } else {
//                System.out.println("Failed!");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        UserRepository repo = new UserRepository();
//        System.out.println(repo.findAll());
//        System.out.println(repo.findUserByCredentials("dlaw", "p4ssw0rd"));
//        System.out.println(repo.findUserByUsername("dlaw"));
//        System.out.println(repo.findUsersByRole(Role.MANAGER));
    }
}
