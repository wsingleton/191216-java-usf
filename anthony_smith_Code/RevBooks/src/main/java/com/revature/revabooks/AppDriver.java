package com.revature.revabooks;

import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.BookRepository;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.screens.Screen;
import com.revature.revabooks.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {

    public static BufferedReader console;
    public static User currentUser;
    public static ScreenRouter router;
    public static boolean appRunning;

    static {
        System.out.println("[LOG] - Initalizing application...");

        appRunning = true;
        console= new BufferedReader((new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final BookRepository bookRepo = new BookRepository();

        final UserService userService = new UserService(userRepo);


    }

    public static void main(String[] args) {

    }
}