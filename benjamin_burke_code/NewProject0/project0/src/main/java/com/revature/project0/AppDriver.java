package com.revature.project0;

import com.revature.project0.models.User;
import com.revature.project0.repos.UserRepository;
import com.revature.project0.screens.*;
import com.revature.project0.services.UserService;
import com.revature.project0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    public static BufferedReader console;
    public static User currentUser;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
       

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();

        final UserService userService = new UserService(userRepo);


        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new UserProfileScreen())
                .addScreen(new SavingScreen())
                .addScreen(new CheckingScreen())
                .addScreen(new ChooseAccountScreen())
                .addScreen(new CreateSaving())
                .addScreen(new SavingScreen())
                .addScreen(new CreateChecking());


    }

    public static void main(String[] args) {

        while (appRunning) {
            router.navigate("/home");
        }

    }
}