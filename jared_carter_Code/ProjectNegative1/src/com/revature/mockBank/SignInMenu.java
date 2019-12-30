package com.revature.mockBank;

import java.util.Scanner;



public class SignInMenu {

    Scanner scanner = new Scanner(System.in);
    BankDriver bank = new BankDriver();

    public static void main(String[] args) {
        SignInMenu signInMenu = new SignInMenu();
        signInMenu.loginMenu();
    }
    public void loginMenu() {
        int option;

        System.out.println("---------------------------");
        System.out.println("Hello Welcome to Kannon.");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("3: Exit");
        System.out.println("---------------------------");

        do {
            System.out.println("Enter an option");
            option = scanner.nextInt();
            System.out.println("/n");
            switch (option) {
                case 1:
                    Account login = new Account();
                    login.loginAccount();

                    break;
                case 2:
                    Account register = new Account();
                    register.registerAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using Kannon's Bank.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid entry, please try again");
            }
        }
            while (option != 3) ;



    }






}




















