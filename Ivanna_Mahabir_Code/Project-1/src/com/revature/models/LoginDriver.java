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
        boolean userValid = myLogin.validate(user);
        if(userValid != true){
            return;
        }

        System.out.println("Password: ");
        String pass = scanner.nextLine();
        boolean passValid = myLogin.validate(pass);
        if(passValid != true){
            return;
        }

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
