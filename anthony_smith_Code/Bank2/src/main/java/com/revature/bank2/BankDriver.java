package com.revature.bank2;

import com.revature.bank2.models.User;
import com.revature.bank2.repos.UserRepository;

import com.revature.bank2.screens.HomeScreen;

public class BankDriver {

     static BankDriver app = new BankDriver();
     static UserRepository userRepo = new UserRepository();
     static User currentUser = new User();

//    public static void main(String[] args) {
//        while (app.isAppRunning()){
//            app.getRouter().navigate("/home");
//        }
//    }
//
//    public static BankDriver app() {
//        return app;
//    }

    public static void main(String[] args) {
        HomeScreen.class;
    }
}
