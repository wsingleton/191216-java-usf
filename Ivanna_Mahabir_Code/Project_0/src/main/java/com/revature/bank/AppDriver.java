package com.revature.bank;

import com.revature.bank.models.Account;
import com.revature.bank.models.User;
import com.revature.bank.repos.AcctRepository;
import com.revature.bank.repos.UserRepository;
import com.revature.bank.screens.HomeScreen;
import com.revature.bank.screens.LoginScreen;
import com.revature.bank.screens.ProfileScreen;
import com.revature.bank.screens.RegisterScreen;
import com.revature.bank.services.AcctService;
import com.revature.bank.services.UserService;
import com.revature.bank.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {
    public static BufferedReader console;
    public static ScreenRouter router;
    public static Boolean appRunning;
    public static User currentUser;
    public static Account currentAcct;


    static {
        System.out.println("[LOG] - Initializing application");
        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final AcctRepository acctRepo = new AcctRepository();

        final UserService userService = new UserService(userRepo);
        final AcctService acctService = new AcctService(acctRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new ProfileScreen(acctService));

        System.out.println("[LOG] Application initialization complete.");

    }


    public static void main(String[] args) {

        while (appRunning) {
            router.navigate("/home");
        }
    }
}