package mockBank.UI;

import mockBank.Service.BalancePage;
import mockBank.Service.Deposit;
import mockBank.Service.Withdraw;

import java.util.Scanner;

public class TransactionMenu {

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
                    BalancePage.showBalance();
                    break;
                case 2:
                    Deposit.deposit();
                    break;
                case 3:
                    Withdraw.withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using Kannon's Bank!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid entry, please try again");
            }

        } while (option != 4);
        
    }

}
