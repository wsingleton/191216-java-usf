package com.bank;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Faux Bank");
        System.out.println("To sign in, press 0");
        System.out.println("To create an account, press 1: ");

        int number = input.nextInt();

        if (number == 0){

            //signIn()
        }
        else if (number == 1){

            //createAcct()
        }
        else{

            System.out.println("Error: Please press 0 or 1");
        }
    }
}
