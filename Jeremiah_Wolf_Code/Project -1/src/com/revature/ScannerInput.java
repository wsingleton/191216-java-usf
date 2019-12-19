package com.revature;
import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {
        String startMessage;
        startMessage = "Welcome to Bank of Java!";
        System.out.println(startMessage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
        Scanner userInput = new Scanner(System.in);
        System.out.println("Existing User");
        String text = userInput.nextLine();
    }
}

        /*if( text == Y)
       {
            System.out.println("Enter username and password");
       }
       else ( text == N)
       {
            System.out.println("Are you a New User?");

            if (text == Y)
            {
                Input new account info
            }

            else (text == N)
            {

            }
       }
          (*/
        /*new Scanner(System.in);
        System.out.println("Enter Username and Password");
        String texta = userInput.nextLine();
        }
    }*/
