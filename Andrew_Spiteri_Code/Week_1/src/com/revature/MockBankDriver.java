package com.revature;

import models.Login;
import models.RegisterUser;

import java.io.IOException;
import java.util.Scanner;

public class MockBankDriver {
          public static void main(String[] args) throws IOException {

        System.out.print("Would you like to register (enter 0) or login (enter 1): ");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.next()){
            case "0":
                System.out.println("Register user function");
                RegisterUser.registerUser();
                break;
            case "1":
                System.out.println("Login function");
                Login.login();
                break;
            default:

                break;
        }
    }

}
