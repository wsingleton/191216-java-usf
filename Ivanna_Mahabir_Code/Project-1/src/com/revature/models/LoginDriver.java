package com.revature.models;

import java.util.Scanner;

public class LoginDriver {
    private User myLogin;

    public void Login(){
        UserB myLog = new UserB();
        System.out.println("Enter your information to login");
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        myLog.validate(scanner.nextLine());
        System.out.println("Password: ");
        scanner = new Scanner(System.in);
        myLog.validate(scanner.nextLine());
    }
}
