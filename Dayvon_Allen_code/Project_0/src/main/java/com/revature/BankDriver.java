package com.revature;

import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.UserService;
import com.revature.util.ScreenRouter;

import java.util.Scanner;

public class BankDriver {

    //will hold user input throughout use of the app
    public static Scanner console;
    //holds the current user throughout use of the app
    public static User currentUser = new User();
    //the router that will control the flow of the app
    public static ScreenRouter router;
    //holds the value that says whether the app is running or not
    public static Boolean appRunning;

    static {
        //changes the status of running to true
        appRunning = true;
        //creates the scanner that will be used throughout the app
        console = new Scanner(System.in);
        final UserRepository userRepo = new UserRepository();
        final UserService userService = new UserService(userRepo);

        router = new ScreenRouter();
        //adds all of the screens to the router so they can be used throughout the app
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new CustomerPortalScreen("Customer Portal", "/customer"))
                .addScreen(new BalanceScreen("Balance Screen", "/balance"))
                .addScreen(new DepositScreen("Deposit Screen", "/deposit"))
                .addScreen(new WithdrawScreen("Withdraw Screen", "/withdraw"));
    }
    public static void main(String[] args) {
        while (appRunning){
            try {
                router.navigate("/home");
            }
            catch (Exception e){

            }
        }
    }

    public static User user() {
        return currentUser;
    }
}
