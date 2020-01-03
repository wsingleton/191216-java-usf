package com.revature.models;

import java.util.List;
import java.util.Scanner;

public class LoginDriver {

    public void Login(List<UserB> myLog){

        UserB myLogin = new UserB();

        System.out.println("Enter your information to login");
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();

        boolean userValid = myLogin.validate(user); //checks if username meets criteria
        if(userValid != true){
            return;
        }

        System.out.println("Password: ");
        String pass = scanner.nextLine();
        boolean passValid = myLogin.validate(pass); //checks if password meets criteria
        if(passValid != true){
            return;
        }

        //if both username and password pass the basic requirements.
        //then the username entered is compared to the usernames in the file.
        //if username is the same, then compare the password.
        // if both are true, display user info.

        try {
            String passw = "";
            for(UserB u : myLog){if(u.getUsername().equals(user)) passw = u.getPassword();}
            if(pass.equals(passw)){
                Display.disPla(myLog, user);
            }

        }
        catch (Exception e){
            System.out.println("invalid user name");
            e.printStackTrace();
        }

    }
}
