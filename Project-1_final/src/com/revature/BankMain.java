package com.revature;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {

        // Make a file to store the user info
        File takeNames = new File("src/stored/usernames_passwords.txt");

        //Prompt register or login
        System.out.println("Enter 'Register' to create a new account or 'Login' sign into an existing account");
        Scanner entry = new Scanner(System.in);
        String path = entry.nextLine();
        while (path.equals("") || (!path.equals("Login") && !path.equals("Register"))) { //user input control
            System.out.println("Please enter either 'Register' or 'Login'");
            entry = new Scanner(System.in);
            path = entry.nextLine();
        }

        //What the user does from here
        if (path.equals("Register")) {

            //Ask user to create their username and password
            System.out.println("Please enter your desired username");
            Scanner console = new Scanner(System.in);
            String username = console.nextLine();
            username = username.replaceAll(" ", ""); // stops the spacing bug

            // Checking if the username is blank
            while (username.equals("")) {
                System.out.println("A username is required");
                console = new Scanner(System.in);
                username = console.nextLine();
            }

            // Checking username availability
            try {
                int lineCount = 0;
                String line = "";

                BufferedReader nameCheck = new BufferedReader(new FileReader(takeNames));

                while ((line = nameCheck.readLine()) != null) {
                    lineCount++;
                    int nameFound = line.indexOf(username);
                    if (nameFound > 0) {
                        System.out.println("This username is already taken. You will be brought back to the register.");
                        System.exit(0);
                    }
                }

                nameCheck.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Please enter your desired password");
            String password = console.nextLine();

            try (BufferedWriter storing = new BufferedWriter(new FileWriter(takeNames, true))) {

                UserInfo u = new UserInfo(username, password, 0.0);
                storing.write("\n" + u.addToStored());

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Your username is: " + username + " and your password is: " + password);
            System.out.println("You will now be taken back to the starting page");
            System.exit(0);

        } else { //Ask user for their username and password

            System.out.println("Please enter your username");
            Scanner enter = new Scanner(System.in);
            String registeredUName = enter.nextLine();
            System.out.println("Please enter your password");
            Scanner enterpw = new Scanner(System.in);
            String registeredPassword = enterpw.nextLine();

            try {
                int lineCount = 0;

                BufferedReader nameAndPasswordCheck = new BufferedReader(new FileReader(takeNames));
                System.out.println(registeredUName + ":" + registeredPassword);

                String line = nameAndPasswordCheck.readLine();

                List<UserInfo> usernamesAndPasswords = new ArrayList<>();

                while (line != null) {
                    String[] userFields = line.split(":");
                    UserInfo u = new UserInfo(userFields[0], userFields[1], Double.parseDouble(userFields[2]));
                    usernamesAndPasswords.add(u);
                    line = nameAndPasswordCheck.readLine();
                }

                int index = 0;
                for (UserInfo u : usernamesAndPasswords) {
                    //check valid login
                    if (registeredUName.equals(u.getUsername()) && registeredPassword.equals(u.getPassword())){
                        System.out.println("login successful");
                        System.out.println("would you like to deposit or withdraw?");
                        System.out.println("if deposit enter 1 if withdraw enter 2, to quit enter 3");

                        Scanner input = new Scanner(System.in);
                        String choice = input.nextLine();

                        switch (choice) {
                            case "1" :

                                //lets make a deposit

                                double amount = 0.0;
                                System.out.println("enter the amount");
                                Scanner deposit = new Scanner(System.in);
                                amount = deposit.nextDouble();

                                double newBalance = u.getBalance() + amount;
                                u.setBalance(newBalance);
                                usernamesAndPasswords.remove(index);
                                usernamesAndPasswords.add(index, u);

                                try {
                                    BufferedWriter storing = new BufferedWriter(new FileWriter(takeNames));
                                    for (UserInfo k : usernamesAndPasswords) {
                                        String m = k.getUsername() +":" + k.getPassword() +":" + k.getBalance();
                                        storing.write(m);
                                        storing.newLine();
                                    }
                                    storing.close();

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                System.out.println("your new balance is :" + newBalance);


                                break;
                            case "2" :

                                //you want to take out more money? :( (withdraws)

                                double amountIn = 0.0;
                                System.out.println("enter the amount");
                                Scanner withdraw = new Scanner(System.in);
                                amountIn = withdraw.nextDouble();

                                double newBalanceSub = u.getBalance() - amountIn;
                                if (u.getBalance() < amountIn) {
                                    System.out.println("you must deposit more money");
                                    System.exit(0);
                                }

                                u.setBalance(newBalanceSub);
                                usernamesAndPasswords.remove(index);
                                usernamesAndPasswords.add(index, u);

                                try {
                                    BufferedWriter storing = new BufferedWriter(new FileWriter(takeNames));
                                    for (UserInfo k : usernamesAndPasswords) {
                                        String m = k.getUsername() + ":" + k.getPassword() + ":" + k.getBalance();
                                        storing.write(m);
                                        storing.newLine();
                                    }
                                    storing.close();

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                System.out.println("your new balance is :" + newBalanceSub);

                                break;
                            case "3" :

                                // leaving the app
                                System.out.println("goodbye");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Please pick 1, 2, or 3");
                                break;

                        }

                        break;
                    }

                    else {
                        if(index >= usernamesAndPasswords.size() -1)
                        System.out.println("Wrong username and password");
                    }

                    index = index + 1;

                }

                nameAndPasswordCheck.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
