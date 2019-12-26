package com.revature;

import com.revature.models.UserB;

// use an array to hold info?? output array separated by :
//Create a temporary object and compare to stored data
// if input is the same as stored data display invalid entry
// import java.lang.reflect.Array;
import java.util.Scanner;

public class RegisterDriver {
    public void Register(){
        UserB myUser = new UserB();
        System.out.println("Enter your information to register");
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String uname = scanner.nextLine();
        myUser.setUsername(uname); //test before set, if invalid reenter
        //myUser.validateUser(scanner.nextLine());
        System.out.println("Password: ");
        scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        myUser.setPassword(pass); //test before set if invalid reenter


    }

}
