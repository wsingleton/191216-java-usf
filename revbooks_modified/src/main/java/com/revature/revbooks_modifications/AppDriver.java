package com.revature.revbooks;

import com.revature.revbooks.models.User;
import com.revature.revbooks.repos.BookRepository;
import com.revature.revbooks.repos.UserRepository;
import com.revature.revbooks.screens.*;
import com.revature.revbooks.services.UserService;
import com.revature.revbooks.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    public static BufferedReader console;
    public static User currentUser;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("[LOG] - Initializing application...");

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final BookRepository bookRepo = new BookRepository();
        final UserService userService = new UserService(userRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashboardScreen())
                .addScreen(new UserProfileScreen())
                .addScreen(new SearchBooksScreen());

        System.out.println("[LOG] - Application initialization complete.");
    }

    public static void main(String[] args) {

        while (appRunning) {
            router.navigate("/home");
        }
    }
}
