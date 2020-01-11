package bank;

import java.util.Hashtable;
import java.util.Scanner;

public class Menu {

    private Hashtable<String, Account> acctBase = new Hashtable<>();
    String token = "";





   double  balance = 0;
   int option = 0;
   boolean success = false;

    Scanner scanner = new Scanner(System.in);
    public void loginMenu(){
        System.out.println("---------------------------");
        System.out.println("Bank.");
        System.out.println("1: Make an account");
        System.out.println("2: Sign in");
        System.out.println("3: Exit");
        System.out.println("---------------------------");

        do {


            System.out.println("Enter an option");
            try {
                option = Integer.parseInt(scanner.nextLine());
            }

            catch(Exception e){
                System.out.println("Please select a number: ");
                System.exit(0);
            }
            System.out.println("****************************");

            switch (option) {
                case 1:
                    makingNewAccount();

                    break;
                case 2:

                    signIn();
                    break;
                case 3:
                    System.out.println("Thank you for using Bank.");

                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid entry, please try again");
            }
        }
        while (false) ;
        System.out.println("Invalid username or password.");
    }



    public void transactionMenu() {



        System.out.println("---------------------------");
        System.out.println("1: Make a deposit");
        System.out.println("2: Make a withdraw");
        System.out.println("3: View balance");
        System.out.println("4: Exit");
        System.out.println("---------------------------");

        do {


            System.out.println("Enter an option");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            }
            catch(Exception e){
                System.out.println("Please select a number: ");
            }
            System.out.println("****************************");

            switch (option) {
                case 1:
                    deposit();

                    break;
                case 2:
                  withdraw();
                    break;
                case 3:
                    viewBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using Bank.");


                    System.exit(0);
                default:
                    System.out.println("Invalid entry, please try again");
            }
        }
        while (option != 4) ;


    }


    private void viewBalance() {

        System.out.println("Your current balance is $ "+ balance);
        transactionMenu();
    }

    private void withdraw() {

        boolean valid = false;
        double withdraw = 0;
        System.out.println("Please enter withdraw amount: ");
        while (!valid) {
            try {
                String dummy = scanner.next();
                withdraw = Double.parseDouble(dummy);
            } catch (Exception e) {
                System.out.println("Please enter a number: ");
            }
            if (withdraw < balance + 1) {
                balance = balance - withdraw;
                acctBase.get(token).setBalance(balance);
                valid = true;
            } else {

                System.out.println("You do not have enough to withdraw: ");
                transactionMenu();
            }


        }
        transactionMenu();
    }


    private void deposit() {
        boolean valid = false;
        double deposit = 0;
        System.out.println("Please enter deposit amount: ");
        while (!valid) {
            try {
                String dummy = scanner.next();
                deposit = Double.parseDouble(dummy);
            } catch (Exception e) {
                System.out.println("Please enter a number: ");
            }
            if (deposit > 0) {
                balance = deposit + balance;
                acctBase.get(token).setBalance(balance);
                valid = true;
            } else {

                System.out.println("Please deposit amount greater than zero.");

                transactionMenu();
            }


        }
        transactionMenu();
    }
        private void makingNewAccount(){
            String userName, password, accountNumber;
            double initialDeposit = 0;
            System.out.println("Enter a username: ");
            userName = scanner.nextLine();
            System.out.println("Enter a password: ");
            password = scanner.nextLine();
            boolean valid = false;
            while (!valid) {
                System.out.println("Please enter an initial deposit: ");
                try {
                    String dummy = scanner.next();
                    balance = Double.parseDouble(dummy);
                } catch (Exception e) {
                    System.out.println("Please enter a number: ");

                }
                if (balance < 0) {
                    System.out.println("Please enter a positive number: ");

                } else {
                    valid = true;
                }

            }

            acctBase.put(userName,new Account(userName,password,balance) );
            token = userName;
            transactionMenu();



        }

    public void signIn() {
        System.out.println("Enter Username: ");
        String username = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();

        if (acctBase.containsKey(username) && acctBase.get(username).getPassword().equals(password)) {
            success = true;
            token = username;
            balance = acctBase.get(username).getBalance();
            transactionMenu();
        }
    }
}

