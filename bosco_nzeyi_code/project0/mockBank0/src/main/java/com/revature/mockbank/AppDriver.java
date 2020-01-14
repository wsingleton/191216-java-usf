package com.revature.mockbank;

/*
Main method class to initiate the application
 */

import com.revature.mockbank.models.User;
import com.revature.mockbank.repositories.UserRepo;
import com.revature.mockbank.screens.*;
import com.revature.mockbank.services.UserService;
import com.revature.mockbank.util.ConnectionFactory;
import com.revature.mockbank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class AppDriver {

    public static BufferedReader console;
    public static User currentUser;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("Initializing application ........");
        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));
        final UserRepo userRepo = new UserRepo();
        // bank repo and other db models will go here

        final UserService userService = new UserService(userRepo);
        // account services and other models will go here

        router = new ScreenRouter();
        // screens will be added from here
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService)) // add user service as a parameter for register
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashboardScreen())
                .addScreen(new UserProfileScreen())
                .addScreen(new DepositScreen());
    }

    public static void main (String[] args){
//
        while (appRunning) {
            router.navigate("/home");
        }
//        Connection con = ConnectionFactory.getInstance().getConnection();
//     if(con != null){
//         System.out.println("Connection established! You are good to go");
//     } else{
//         System.out.println("Ni za nduru! ");
//     }
    }
}
