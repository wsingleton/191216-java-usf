package mockBank.UI;

import java.util.Scanner;

public class Withdraw {

    public static void withdraw() {
        double balance;
        System.out.println("Enter withdraw amount: ");
        Scanner scanner = new Scanner(System.in);

        double amount = scanner.nextDouble();

        double withdraw(amount){
            if (amount > 0) {
                balance = balance - amount;
                System.out.println("Your balance is now : " + balance);

            } else {
                System.out.println("Please withdraw amount greater than zero.");
            }
        }
    }
}
