package com.revature;

import com.revature.models.LoginDriver;
import com.revature.models.ReadFile;
import com.revature.models.UserB;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPageDriver {
    static ArrayList<UserB> ulist = new ArrayList<>(ReadFile.ReadFile());

    public static void main(String[] args) {
        try {
            //Main Page Display Start
            System.out.println("Welcome to C Bank!");
            System.out.println("New user enter 1, returning user enter 2 (to exit enter -1): ");

            //reads input from the user
            Scanner scanner = new Scanner(System.in);
            Integer option = scanner.nextInt(); //if non-int is entered InputMismatchException
            if (option > 3 || option < -2 || option == 0) {
                System.out.println("Invalid Entry");
                return;
            } else {

                switch (option) {
                    case 1:
                        System.out.println("Welcome New User");
                        RegisterDriver myRegister = new RegisterDriver();
                        myRegister.Register(ulist);

                        break;
                    case 2:
                        System.out.println("Please login");
                        LoginDriver myLogin = new LoginDriver();
                        myLogin.Login(ulist);
                        break;

                    case -1:
                        System.out.println("Goodbye");
                        return;

                    default:
                        System.out.println("Invalid Entry");
                        return;

                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Input");
            e.printStackTrace();
            return;
        }
    }
}