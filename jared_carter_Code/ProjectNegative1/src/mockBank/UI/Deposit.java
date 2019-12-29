package mockBank.UI;

import java.util.Scanner;

public class Deposit {


    public static void deposit() {
        double balance;
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        double deposit (double amount){
            if (amount > 0) {
                balance = amount + balance;
            } else {
                System.out.println("Please deposit amount greater than zero.");
            }
            return balance;
        }
    }
}
