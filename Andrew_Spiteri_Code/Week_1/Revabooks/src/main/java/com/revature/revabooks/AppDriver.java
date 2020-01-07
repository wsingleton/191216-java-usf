package com.revature.revabooks;

import com.revature.revabooks.models.User;
import com.revature.revabooks.repositories.BookRepository;
import com.revature.revabooks.repositories.UserRepository;
import com.revature.revabooks.screens.*;
import com.revature.revabooks.services.BookService;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {
    public static BufferedReader console;
    public  static ScreenRouter router;
    public static Boolean appRunning;
    public  static User currentUser;

    static {
        System.out.println("[LOG] - Initializing application...");
        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final BookRepository bookRepo = new BookRepository();

        final UserService userService = new UserService(userRepo);
        //final BookService bookService = new BookService(bookRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen(userService))
                .addScreen(new DashboardScreen())
                .addScreen(new UserProfileScreen())
                .addScreen(new SearchBooksScreen());

        System.out.println("[LOG] - Application initializing complete.");
    }

    public static void main(String[] args) {
        while(appRunning) {
            router.navigate("/home");
        }
    }
}
