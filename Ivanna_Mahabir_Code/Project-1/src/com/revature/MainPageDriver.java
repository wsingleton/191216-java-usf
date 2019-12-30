package com.revature;

import com.revature.RegisterDriver.*;
import com.revature.models.LoginDriver;
import com.revature.models.UserB;
//import com.revature.models.ReadInput;
//import com.revature.models.UserB.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPageDriver {
    public static void main(String[] args){

        //Main Page Display Start
        System.out.println("Welcome to C Bank!");
        System.out.println("New user enter 1, returning user enter 2 (to exit enter -1): ");
        //reads input from the user
        Scanner scanner = new Scanner(System.in);
        Integer option = scanner.nextInt();

       // Integer opt = new ReadInput(); 

        //test or validate input using if or switch statement
        //a while loop with a nested if statement??
        switch(option){
            case 1:
                System.out.println("Welcome New User");
                RegisterDriver myRegister = new RegisterDriver();
                myRegister.Register();

                break;
            case 2:
                System.out.println("Please login");
                LoginDriver myLogin = new LoginDriver();
                myLogin.Login();
                break;
            case -1:
                return;

            default:
                System.out.println("Invalid Entry");

        }



    }
}
