package com.bank;
import java.util.Scanner;

public class UserInterface {

    double balance;

    public void display(){

        Scanner input = new Scanner(System.in);

        System.out.println("Check Balance = 0");
        System.out.println("Deposit = 1");
        System.out.println("Withdraw = 2");
        System.out.print("Please choose an option");
        int number = input.nextInt();

        if (number == 0){

            checkBalance();
        }
        else if(number == 1){

            deposit();
        }
        else if(number == 2){

            withdraw();
        }
        else{

            System.out.println("Error: Please try again");
            System.out.println("");
            display();
        }
    }

    public void checkBalance(){

        System.out.println("");
        System.out.println("Your Balance: $" + balance);

    }

    public void deposit(){

        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("Your Balance: $" + balance);
        System.out.print("Enter the deposit amount: ");
        double amount = input.nextDouble();

        if (amount <= 0){

            System.out.println("Please enter a new amount.");
            deposit();

        }
        else {

            balance += amount;

        }
        System.out.println("");
        System.out.println("");
        System.out.println("Your new balance is " + balance);

    }

    public void withdraw(){


    }
}
