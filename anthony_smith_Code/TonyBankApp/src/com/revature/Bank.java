package com.revature;
import java.util.*;

public class Bank {


    HashMap<String, User> userDb = new HashMap<>();
    String token = "";
    {
        userDb.put("asmithjr89", new User("asmithjr89", "Goldwatch11", 1000.89));
        userDb.put("focean", new User("focean", "inmyroom", 200.00));
        userDb.put("scarter", new User("scarter", "beyonce", 1000000.99));
        userDb.put("khart", new User("khart", "dwayne", 1000.67));
    }

    public Bank() {
        FileReader fr = new FileReader();
        fr.filedMap(userDb);
    }

    public void createNewUser() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter in a User Name");
        String userName = scanner.nextLine();

        System.out.println("Please enter in a password");
        String passWord = scanner.nextLine();

        System.out.println("You must enter a initial Deposit. Please enter the amount you wish to deposit");
        double accountBalance = scanner.nextDouble();

        userDb.put(userName,new User(userName, passWord, accountBalance));
        token = userName;
        bankingOperations();



    }


    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter in your username:");
        String unInput = scanner.next();
        System.out.println("Please enter in your password: ");
        String pwInput = scanner.next();

         if( userDb.containsKey(unInput) && userDb.get(unInput).getPassword().equals(pwInput)) {
             token = unInput;
             bankingOperations();
        } else {
             System.out.println("Invalid Credentials, Please Try Again");
         }

    }

    public void bankingOperations() {

        Scanner scanner = new Scanner(System.in);


        System.out.println("\tPlease make a selection\n");

        System.out.println("1.\t Withdraw");
        System.out.println("2.\t Deposit");
        System.out.println("3.\t Display Balance");
        System.out.println("4.\t Exit");

        String choice = "";
        boolean success = false;
        while (!success) {
            System.out.println();
            try {
                choice = scanner.next();
            } catch (Exception e) {
                System.out.println("not an string");
            }
            success = true;

            switch (choice) {

                case "1":
                     withdraw();
                    break;

                case "2":
                    deposit();
                    break;

                case "3":
                    displayBalance();
                    break;

                case "4":

                    WriteToFile wtf = new WriteToFile();
                    wtf.writeMap(userDb);
                    System.exit(0);
                    break;

                default:
                    success = false;
                    System.out.println("You selected an invalid selection. Please try again.");

            }

            WriteToFile wtf = new WriteToFile();
            wtf.writeMap(userDb);

        }

        bankingOperations();
    }


    public void withdraw() {
        Scanner scanner = new Scanner(System.in);

       Double cBalance =  userDb.get(token).getAccountBalance();
        boolean valid = false;
        double amount = 0;
        System.out.println("How much would you like to withdraw ?");
        while(!valid){
            try{
                amount = Double.parseDouble(scanner.nextLine());
            } catch (Exception e){
                System.out.println("You made  an invalid entry. Please try again.");
            }
            if (amount > cBalance ) {
                System.out.println("Not enough funds, Transaction Decline");
            }
            if(amount >0){
                userDb.get(token).setAccountBalance(cBalance - amount) ;
                valid = true;
            }
        }

 }


    public void  deposit() {

        Scanner scanner = new Scanner(System.in);

        Double cBalance = userDb.get(token).getAccountBalance();
        boolean valid = false;
        double amount = 0;
        System.out.println("How much do you want to deposit ?");
        while (!valid) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("You made  an invalid entry. Please try again.");
            }


             if(amount > 0) {
                userDb.get(token).setAccountBalance(cBalance + amount);
                valid = true;
            }
        };
    }

        public void displayBalance(){
            Double cBalance =  userDb.get(token).getAccountBalance();
            System.out.println("Your account balance is " + cBalance);
        }

    }

