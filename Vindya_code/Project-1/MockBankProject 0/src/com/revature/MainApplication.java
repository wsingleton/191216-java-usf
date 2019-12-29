package com.revature;

import java.io.File;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String user, pass;
        System.out.println("Enter your your name");
        user = input.nextLine();
        System.out.println("Enter your password");
        pass = input.nextLine();

        BankAccount account3 = new BankAccount("a","b",10,10,10);

        if(user.equals("Vindya")&& (pass.equals("Victory"))) {
            BankAccount account1 = new BankAccount(250,100);
            System.out.println("Welcome to your favorite bank");
            System.out.println("Withdraw, deposit or view?");
            int option = input.nextInt();
            if(option == 0){
                System.out.println("How much would you like to withdraw?");
                double amount = input.nextDouble();
                account1.withdrawal(amount);
            }
        }else if(user.equals(account3.getUsername())&& pass.equals("b")){
            BankAccount account2 = new BankAccount(100,11);
        }else{
            System.out.println("Welcome back later");
            System.exit(0);

        }
        File users = new File("src/resources/users.txt");
         double balance;


    }
}
