package mockBank.Service;

import java.util.Scanner;

public class Register {

    Scanner scanner = new Scanner(System.in);
    public void registerAccount() {
        String firstName, lastName, userName, password = " ";
        System.out.println("Please enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Please enter last name: ");
        lastName = scanner.nextLine();
        System.out.println("Please enter user name: ");
        userName = scanner.nextLine();
        System.out.println("Please enter password: ");
        password = scanner.nextLine();



    }
}
