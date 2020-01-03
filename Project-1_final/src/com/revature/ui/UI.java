package com.revature.ui;

import java.util.Scanner;

public class UI {

    public static String choseYourDestiny() {

        System.out.println("Enter 'Register' to create a new account or 'Login' sign into an existing account");
        Scanner entry = new Scanner(System.in);
        String path = entry.nextLine();
        while (path.equals("") || (!path.equals("Login") && !path.equals("Register"))) { //user input control
            System.out.println("Please enter either 'Register' or 'Login'");
            entry = new Scanner(System.in);
            path = entry.nextLine();
        }

        return path;
    }

    public void loginOrRegister(String path) {
        switch (path) {
            case "Login":
                Login.loginInfo();
                break;
            case "Register":
                System.out.println("Please enter your username");
                break;
        }
    }
}
           /* switch (path) {
                case "Login" :
                    System.out.println("Please choice your desired username");
                    break;
                case "Register" :
                    System.out.println("Please enter your username");
                    break;
                //default : System.out.println("invalid entry");
        }
    }
} */

