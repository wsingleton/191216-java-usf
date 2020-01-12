package com.revature.revabooks;

import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.repos.WishlistRepository;
import com.revature.revabooks.screens.*;
import com.revature.revabooks.services.BookService;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.ScreenRouter;
import com.revature.revabooks.util.UserSession;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    public static BufferedReader console;
    public static UserSession currentSession;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("[LOG] - Initializing application...");

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final BookRepository bookRepo = new BookRepository();
        final WishlistRepository wishlistRepo = new WishlistRepository();

        final UserService userService = new UserService(userRepo);
        final BookService bookService = new BookService(bookRepo, wishlistRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
              .addScreen(new RegisterScreen(userService))
              .addScreen(new LoginScreen(userService))
              .addScreen(new DashboardScreen())
              .addScreen(new UserProfileScreen(userService))
              .addScreen(new SearchBooksScreen(bookService));

        System.out.println("[LOG] - Application initialization complete.");

    }

    public static void main(String[] args) {

        while (appRunning) {
            router.navigate("/home");
        }

    }
}
