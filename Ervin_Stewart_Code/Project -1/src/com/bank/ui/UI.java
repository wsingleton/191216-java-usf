package com.bank.ui;
import com.bank.models.User;

import java.util.Scanner;

public class UI {
    static int UserNumInput;
    static String UserStringInput;
    public static void loginScreen(){
        System.out.println("To Login Enter 0");
        System.out.println("To Create An Account Enter 1");
        Scanner input = new Scanner(System.in);
        UserNumInput = input.nextInt();
    switch (UserNumInput){
        case 0:
            System.out.println("User Can now login");
            loginScreen();
            break;
        case 1:
            System.out.println("User can create a login");
            loginScreen();
            break;
        default:
            System.out.println("Not a Valid input");
            loginScreen();


    }
}

    public void createAccount(){
        System.out.println("please enter an email ");
        Scanner input = new Scanner(System.in);
        UserStringInput = input.next();
        //String email = UserStringInput;
        User.setEmail(UserStringInput);

    }

}
