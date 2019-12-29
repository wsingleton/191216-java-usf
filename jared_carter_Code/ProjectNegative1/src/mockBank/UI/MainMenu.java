package mockBank.UI;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;



public class MainMenu {
    public void loginMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);
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

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Thank you for using Kannon's Bank.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid entry, please try again");
            }

            while (option != 3) ;
            System.out.println("Thank you for using Kannon's Bank.");

        }
    }

    double balance;


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

        System.out.println("Thank you for using Kannon's Bank.");
    }



}




















