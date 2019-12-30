package com.revature.util;

import com.revature.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {


    File accounts = new File("src/resources/bank.txt");
    Scanner scanner = new Scanner(System.in);

    List<User> userList = new ArrayList<>();

        public void addUser(String fname, String lname, String username, String password, double amount) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(accounts, true))) {

                User newUser = new User(fname, lname, username, password, amount);
                writer.write("\n" + newUser.toFileString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void logIn() {
            System.out.println("enter username");
            String currentUser = scanner.next();
            System.out.println("enter password");
            String currentPassword = scanner.next();

            try {


                BufferedReader reader = new BufferedReader(new FileReader(accounts));
                String userLine = reader.readLine();


                while (userLine != null) {
                    String[] userFields = userLine.split(":");
                    String tFname = userFields[0];
                    String tLname = userFields[1];
                    String tUname = userFields[2];
                    String tPword = userFields[3];
                    Double tamnt = Double.parseDouble(userFields[4]);
                    User u = new User( tFname, tLname, tUname, tPword, tamnt);


                    userList.add(u);
                    userLine = reader.readLine();

                }
            }

            catch (IOException e) {
                System.err.println("Exception thrown reading the file");
            }

            catch (Exception e) {
                System.err.println("An unexpected exception has been thrown");
            }

            for (User s : userList) {
                if(s.getUsername().equals(currentUser) && s.getPassword().equals(currentPassword)){
                    System.out.println("Welcome " + s.getfName() + ", press 1 to withdraw or 2 to deposit");
                    String temp1 = scanner.next();
                    if (temp1.equals("1")){
                        System.out.println("How much would you like to withdraw?");
                        double temp = Double.parseDouble(scanner.next());
                        if (s.getBalance() - temp < 0) {
                            System.out.println("Insufficient funds, Try again");
                        }
                        else {
                            s.setBalance(s.getBalance() - temp);
                            System.out.println("Your new balance is: " + s.getBalance() + ", thanks for doing business.");
                            saveChanges(userList);
                        }
                    } else if(temp1.equals("2")){
                        System.out.println("How much would you like to deposit?");
                        double deposit = Double.parseDouble(scanner.next());
                        s.setBalance(s.getBalance() + deposit);
                        System.out.println("Your new balance is:" + s.getBalance() + ", thanks for doing business.");
                        saveChanges(userList);
                    }
                    else {
                        System.out.println("Invalid option.");
                    }
                }
            }

        }

        public List<User> getUserList() {

            try {

                BufferedReader reader = new BufferedReader(new FileReader(accounts));
                String userLine = reader.readLine();

                while (userLine != null) {
                    String[] userFields = userLine.split(":");
                    System.out.println(userFields.toString());
                    User u = new User(userFields[0], userFields[1], userFields[2], userFields[3], Double.parseDouble(userFields[4]));
                    userList.add(u);
                    userLine = reader.readLine();
                }


            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Exception thrown reading the file");
            }

            catch (Exception e) {
                e.printStackTrace();
                System.err.println("An unexpected exception occurred.");
            }
            return userList;
        }

        public void signUp() {
            System.out.println("please enter first name: ");
            String fname = scanner.next();
            System.out.println("please enter last name: ");
            String lname = scanner.next();
            System.out.println("please enter username: ");
            String username = scanner.next();
            System.out.println("please enter password: ");
            String password = scanner.next();
            System.out.println("please enter initial deposit amount with numbers only: ");
            double amount = Double.parseDouble(scanner.next());

            addUser(fname, lname, username, password, amount);
        }

        public void saveChanges(List<User> userList) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(accounts));

                for (User u : userList) {
                    writer.write(u.toFileString());
                    writer.newLine();
                }
                writer.close();
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }

        public boolean userExists(String username) {
            int i = 0;
            for (User s : userList ) {
                if (s.getUsername().equals(username)) {
                    i++;
                }
            }
            if (i > 0) {
                return true;
            }
            else {
                return false;
            }
        }



}
