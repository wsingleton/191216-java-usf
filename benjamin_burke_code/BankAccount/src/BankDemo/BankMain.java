package BankDemo;
import

import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {

        Account account = new Account();
    }

    public class Login {
        public void run() {
            Scanner scan = new Scanner (new File());
            Scanner keyboard = new Scanner (System.in);
            String user = scan.nextLine();
            String pass = scan.nextLine(); // looks at selected file in scan

            String inpUser = keyboard.nextLine();
            String inpPass = keyboard.nextLine(); // gets input from user

            if (inpUser.equals(user) && inpPass.equals(pass)) {
                System.out.print("your login message");
            } else {
                System.out.print("your error message");
            }
        }
    }
}
