package com.revature.revabooks;

import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.*;
import com.revature.revabooks.services.BookService;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.ScreenRouter;

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
        console=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[LOG] - Generating repositories.");
        final UserRepository userRepo=new UserRepository();
        final BookRepository bookRepo=new BookRepository();
        System.out.println("[LOG] - Preparing application services.");
        final UserService userService=new UserService(userRepo);
        //final BookService bookService=new BookService(bookRepo);
        router=new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new LoginScreen(userService))
                .addScreen(new RegisterScreen(userService))
                .addScreen(new DashboardScreen())
                .addScreen(new UserProfileScreen())
                .addScreen(new SearchBooksScreen());
        System.out.println("[LOG] - Initialization complete.");
    }
    public static void  main(String[] args) {
        while (appRunning) {
            router.navigate("/home");
        }
    }
}
