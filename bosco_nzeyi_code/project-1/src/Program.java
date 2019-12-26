import java.util.Scanner;

public class Program {
    /*
    User Interface class
     */
    public static void main (String [] args){
        // welcome screen
        System.out.println("Welcome to mockBbank!" + "\n" + "Please select one option below to continue " + "\n" +
                "1. Enter 1 to sign up (new users) " + "\n" + "2. Enter 2 to log in (for existing users only)");

        // current user
        String currentUser;
        Scanner read = new Scanner(System.in);
        String choice = read.nextLine();

        String userChoice = choice.toLowerCase();
//        System.out.println("you chose " + userChoice);
        switch (userChoice){

            case "1":
                SignUpUsers user = new SignUpUsers();
                user.getInput();
                break;

            case "2":
                UserLogIn in = new UserLogIn();
                System.out.println("Enter your Username");
                String username = read.nextLine();
                System.out.println("Enter your password");
                String password = read.nextLine();
                in.login(username, password);
                currentUser = in.LoggedId;
                break;

            case "withdraw":


            default:
                System.out.println("Enter the appropriate option please");
        }


    }
}
