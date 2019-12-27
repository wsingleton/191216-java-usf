package mockBank;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class BankMenu {

    void showMenu() {
        char option = 'o';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + userName + " your account number is :");
        System.out.println("A: View balance");
        System.out.println("B: Deposit money");
        System.out.println("C: Withdraw money");
        System.out.println("D: Exit");

        do {
            System.out.println("Enter an option");
            option = scanner.next().charAt(0);
            System.out.println("/n");
            switch (option) {
                case 'A':
                    System.out.println("Balance = " + balance);
                    break;
                case 'B':
                    System.out.println("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("Enter withdraw amount: ");
                    double amount = scanner.nextDouble();
                    withdraw(amount);
                    break;
                case 'D':
                    System.out.println("Thank you!");

                    break;

                default:
                    System.out.println("Invalid entry, please try again");

            }

            }
        }
    }
}







