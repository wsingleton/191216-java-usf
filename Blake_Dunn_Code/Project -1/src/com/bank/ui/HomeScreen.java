package com.bank.ui;

import java.util.Scanner;


public class HomeScreen {

   public void display() {


       Scanner input = new Scanner(System.in);

       System.out.println("Check Balance = 0");
       System.out.println("Deposit = 1");
       System.out.println("Withdraw = 2");
       System.out.print("Please choose an option: ");
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

}
