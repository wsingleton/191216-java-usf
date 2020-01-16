package com.revature;

import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.UserServices;
import com.revature.util.ScreenNavigation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankMain {

    public static User currentUser;
    public static ScreenNavigation navigation;
    public static boolean appLaunched;
    public static BufferedReader userInputs;

    static {

        final UserRepository uRepo = new UserRepository();
        final UserServices userServices = new UserServices(uRepo);

        appLaunched = true;
        userInputs = new BufferedReader(new InputStreamReader(System.in));
        navigation = new ScreenNavigation();
        navigation.addScreen(new HomeScreen());
        navigation.addScreen(new AccountScreen());
        navigation.addScreen(new LoginScreen());
        navigation.addScreen(new ProfileScreen());
        navigation.addScreen(new RegisterScreen(userServices));
        navigation.addScreen(new SearchScreen());
    }

    public static void main(String[] args) {

        while (appLaunched) {
            navigation.navigate("/home");
        }
    }
}
