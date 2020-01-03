package PracticeDriver;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class OrderTwoCities {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first city: ");
        String city1= input.nextLine();
        System.out.println("Enter the second city: ");
        String city2= input.nextLine();

        if (city1.compareTo(city2)<0)
            System.out.println("The cities in alphabetical order are " + city1 + "," + city2);
        else
            System.out.println("The cities in alphabetical order are " + city2 + " " + city1);

        System.out.println("-------------------------------------------------------------------");

        String message = "Welcome to Java";

        String welcome = message.substring(0,11) + "Revature";

        System.out.println(welcome);

        System.out.println("-------------------------------------------------------------------");

        String s = "Benjamin Burke";

        int k = s.indexOf(' ');
        String firstName = s.substring(0, k);
        String lastName = s.substring(k + 1);
        System.out.println(k);

    }

}
