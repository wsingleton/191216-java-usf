package com.revature.bank2.services;

import java.util.Scanner;

public class UserServices {

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);

        Double cBalance =  userDb.get(token).getAccountBalance();
        boolean valid = false;
        double amount = 0;
        System.out.println("How much would you like to withdraw ?");
        while(!valid){
            try{
                amount = Double.parseDouble(scanner.nextLine());
            } catch (Exception e){
                System.out.println("You made  an invalid entry. Please try again.");
            }
            if (amount > cBalance ) {
                System.out.println("Not enough funds, Transaction Decline");
            }
            if(amount >0){
                userDb.get(token).setAccountBalance(cBalance - amount) ;
                valid = true;
            }
        }

    }

    public void  deposit() {

        Scanner scanner = new Scanner(System.in);

        Double cBalance = userDb.get(token).getAccountBalance();
        boolean valid = false;
        double amount = 0;
        System.out.println("How much do you want to deposit ?");
        while (!valid) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("You made  an invalid entry. Please try again.");
            }


            if(amount > 0) {
                userDb.get(token).setAccountBalance(cBalance + amount);
                valid = true;
            }
        }

        public void displayBalance(){
            Double cBalance =  userDb.get(token).getAccountBalance();
            System.out.println("Your account balance is " + cBalance);
        }
    }

}
