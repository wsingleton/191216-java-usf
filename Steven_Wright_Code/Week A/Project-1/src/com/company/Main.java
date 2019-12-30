package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Would you like to register (0) the user or login (1)?");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.next()){
            case "0":
                System.out.println("Register user:");
                try{
                    RegisterUser.registerUser();
                } catch(IOException use){
                    main(null);
                }
                break;
            case "1":
                System.out.println("Logon:");
                Logon.logon();
                break;
            default:
                main(null);

        }

        Logon.logon();
    }
}