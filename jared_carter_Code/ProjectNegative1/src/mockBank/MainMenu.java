package mockBank;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;



public class MainMenu {
    public static void loginMenu() {
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
                    ;
                    break;
                case 2:

                    break;
                case 3:

                    break;

                default:
                    System.out.println("Invalid entry, please try again");
            }
            while (option != 3) ;
            System.out.println("Thank you for using Kannon's Bank.");

        }
    }
}




















