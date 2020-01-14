package com.revature;

import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.UserService;
import com.revature.util.ScreenRouter;

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
                .addScreen(new LoginScreen(userService))
                .addScreen(new RegisterScreen(userService))
                .addScreen(new CustomerSelection())
                .addScreen(new DepositScreen())
                .addScreen(new WithdrawScreen());
    }

    public static void main(String[] args) {

        while (appRunning){
            router.navigate("/home");

        }
    }
}
