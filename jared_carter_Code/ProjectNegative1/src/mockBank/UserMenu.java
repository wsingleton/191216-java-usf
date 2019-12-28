package mockBank;

import java.util.Scanner;

public class UserMenu {
    double balance;


    double deposit(double amount) {
        if (amount > 0) {
            balance = amount + balance;
        } else {
            System.out.println("Please deposit amount greater than zero.");
        }
        return balance;

    }

    double withdraw(double amount2) {
        if (amount2 > 0) {
            balance = balance - amount2;
            System.out.println("Your balance is now : " + balance);

        } else {
            System.out.println("Please withdraw amount greater than zero.");
        }

        return balance;
    }

    void viewBalance() {

        System.out.println("Your current balance: " + balance);


    }

    void transactionMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------");
        // System.out.println("Hello " + userName + " your account number is :");
        System.out.println("1: View balance");
        System.out.println("2: Deposit money");
        System.out.println("3: Withdraw money");
        System.out.println("4: Exit");
        System.out.println("------------------------------------------");

        do {
            System.out.println("Enter an option");
            option = scanner.nextInt();
            System.out.println("/n");
            switch (option) {
                case 1:
                    System.out.println("Balance = " + balance);
                    break;
                case 2:
                    System.out.println("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    break;
                case 3:
                    System.out.println("Enter withdraw amount: ");
                    double amount2 = scanner.nextDouble();
                    withdraw(amount2);
                    break;
                case 4:
                    System.out.println("Thank you for using Kannon's Bank!");

                    break;

                default:
                    System.out.println("Invalid entry, please try again");
            }

        } while (option != 4);

        System.out.println("Thank you for using Kannon's Bank.");
    }

}


