package com.revature.models;

import com.revature.MainPageDriver;

import java.util.List;
import java.util.Scanner;

public class LoginDriver {

    public static void Login(List<UserB> myLog){

        UserB myLogin = new UserB();

        System.out.println("Enter your information to login");
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        System.out.println("Password: ");
        String pass = scanner.nextLine();

        boolean userValid = myLogin.validate(user); //checks if username meets criteria
        boolean passValid = myLogin.validate(pass); //checks if password meets criteria
        if(userValid!= true ||passValid != true){
            System.out.println("Invalid Input\n");
            MainPageDriver.main(null);
        }

        //if both username and password pass the basic requirements.
        //then the username entered is compared to the usernames in the file.
        //if username is the same, then compare the password.
        // if both are true, display user info.

        try {
            for(UserB u : myLog){
                if(u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                    Display.disPla(myLog, user);
                }
            }
            MainPageDriver.main(null);
            //LoginDriver.Login(myLog);

        }
        catch (Exception e){
            System.out.println("\nInvalid Entry");
            Display.disPla(myLog, user);
        }

    }
}
