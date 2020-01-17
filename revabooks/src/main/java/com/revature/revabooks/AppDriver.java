package com.revature.revabooks;

import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.repos.WishlistRepository;
import com.revature.revabooks.screens.*;
import com.revature.revabooks.services.BookService;
import com.revature.revabooks.services.UserService;
import com.revature.revabooks.util.AppState;
import com.revature.revabooks.util.ScreenRouter;
import com.revature.revabooks.util.UserSession;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    private static AppState app = new AppState();

    public static void main(String[] args) {

        while (app.isAppRunning()) {
            app.getRouter().navigate("/home");
        }

    }

    public static AppState app() {
        return app;
    }
}
