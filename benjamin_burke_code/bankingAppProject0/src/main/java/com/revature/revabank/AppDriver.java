package com.revature.revabank;

import com.revature.revabank.models.User;
import com.revature.revabank.repos.AccountRepository;
import com.revature.revabank.repos.UserRepository;
import com.revature.revabank.screens.*;
import com.revature.revabank.services.UserService;
import com.revature.revabank.util.ScreenRouter;


import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    public static BufferedReader console;
    public static User currentUser;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("[LOG] - Initializing application...");

        appRunning=true;
        console= new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final AccountRepository accRepo = new AccountRepository();

        final UserService userService = new UserService(userRepo);


        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new Dashboard())
                .addScreen(new BalanceScreen())
                .addScreen(new WithdrawScreen())
                .addScreen(new DepositScreen());

        System.out.println("[LOG] - Application initialization complete");

    }

    public static void main(String[] args) {
        while(appRunning) {
            router.navigate("/home");
        }
    }
}
