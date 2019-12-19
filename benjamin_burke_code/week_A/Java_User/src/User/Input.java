package User;
import java.util.Scanner;

public class Input {
    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in); //create the scanner input
        Scanner passwordObj = new Scanner(System.in);
        System.out.println("To register, please enter a username: ");

        String userName = myObj.nextLine(); // The user input for username
        System.out.println("Please Enter a password: ");
        String password = passwordObj.nextLine();//user input for password

        System.out.println("Username: " + userName);
        System.out.println("Password: " + password);


    }
}
