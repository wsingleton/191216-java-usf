package mockBank.Service;

import java.util.Scanner;

public class Deposit {

    public static void deposit() {
        //double balance = 0;
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
            if (amount > 0) {
               // balance = amount + balance;
            } else {
                System.out.println("Please deposit amount greater than zero.");
            }

        }
    }
}