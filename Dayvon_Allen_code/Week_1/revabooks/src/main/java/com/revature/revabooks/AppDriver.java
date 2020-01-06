package com.revature.revabooks;

import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.*;
import com.revature.revabooks.services.BookService;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.ScreenRouter;

import java.util.Scanner;

public class AppDriver {

    public static Scanner console;
    public static User currentUser;
    public static ScreenRouter router;
    public static Boolean appRunning;

    static {
        System.out.println("[LOG] - Initializing application...");
        appRunning = true;
        console = new Scanner(System.in);
        final UserRepository userRepo = new UserRepository();
        final BookRepository bookRepo = new BookRepository();

        final UserService userService = new UserService(userRepo);
//        final BookService bookService = new BookService(bookRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashboardScreen())
                .addScreen(new UserProfileScreen())
                .addScreen(new SearchBookScreen());

        System.out.println("[LOG] - Initializing complete...");

    }

    public static void main(String[] args) {

        while (appRunning){
            router.navigate("/home");
        }

    }
}
