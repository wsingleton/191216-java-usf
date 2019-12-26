package com.revature.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static void showMainMenu(){
        System.out.print("+---------------------------------+" +
                "\nWelcome to Dayvon's Bank!\n" +
                "\n" +
                "Please press the number that corresponds to the task that you would like to complete.\n\n" +
                "[1] Login\n" +
                "[2] Register\n" +
                "[3] Quit\n" +
                "+---------------------------------+\n" +
                "Input: ");
    }

    public static void showCustomerPortal(){
        System.out.println("+-------------------------------------------+");
        System.out.println("\nCustomer Portal\n" + "" +
                "[1] Deposit Money\n" +
                "[2] Withdraw Money\n" +
                "[3] Show Balance\n" +
                "[q] Quit\n");
    }

    public static void usernamePrompt(){
        System.out.println("+-------------------------------------------+");
        System.out.println("Please Type in your username(Type \"q\" to quit. Username cannot be empty, spaces will be filtered out)\n");
        System.out.print("\nInput: ");
    }

    public static  void passwordPrompt(){
        System.out.println("+-------------------------------------------+");
        System.out.println("\nPlease Type in your password(Type \"q\" to quit)\n");
        System.out.print("\nInput: ");
    }

    public static boolean usernameExists(String testLine){
        File userText = new File("src/com/revature/resources/users.txt");
        try {
            BufferedReader reader = new BufferedReader((new FileReader(userText)));
            String line = reader.readLine();
            List<String> lines = new ArrayList<>();


            while (line != null) {
//                System.out.println(line);
                line = reader.readLine();
                lines.add(line);
            }

            for (String s : lines) {
                if(s != null)
                    if(s.split(" ")[0].equals(testLine)){
                        return true;
                    }
            }

        }
        catch (Exception e) {
            System.err.println("An unexpected exception");
        }
        return false;
    }

    public static Boolean passwordMatches(String password) {
        File userText = new File("src/com/revature/resources/users.txt");
        try {
            BufferedReader reader = new BufferedReader((new FileReader(userText)));
            String line = reader.readLine();
            List<String> lines = new ArrayList<>();


            while (line != null) {
//                System.out.println(line);
                line = reader.readLine();
                lines.add(line);
            }

            for (String s : lines) {
                if(s != null)
                    if(s.split(" ")[1].equals(password)){
                        return true;
                    }
            }

        }
        catch (Exception e) {
            System.err.println("An unexpected exception");
        }
        return false;
    }

    public static String showBalance(String username){
        File userText = new File("src/com/revature/resources/users.txt");
        try {
            BufferedReader reader = new BufferedReader((new FileReader(userText)));
            String line = reader.readLine();
            List<String> lines = new ArrayList<>();


            while (line != null) {
//                System.out.println(line);
                line = reader.readLine();
                lines.add(line);
            }

            for (String s : lines) {
                if(s != null)
                    if(s.split(" ")[0].equals(username)){
                        return s.split(" ")[2];
                    }
            }

        }
        catch (Exception e) {
            System.err.println("An unexpected exception");
        }
        return "";
    }

    public static void invalidCredential(){
        System.out.println("+-------------------------------------------+");
        System.out.println("\nInvalid credentials!\n");
    }

    public static void withdrawHelper(String username, String password, String balance, String newBalance){
        File userText = new File("src/com/revature/resources/users.txt");
        File writeFile = new File("src/com/revature/resources/users.txt");
        String fullContent = "\n";
        String modified;

        try {
            BufferedReader reader = new BufferedReader((new FileReader(userText)));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                fullContent += line + "\n";
            }
        }
        catch (Exception e) {
            System.err.println("An unexpected exception");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))) {
            modified = fullContent.replaceAll(username + " " + password + " " + balance, username + " " + password + " " + newBalance).replaceAll("null", "");
            writer.write(modified);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void depositHelper(String username, String password, String balance, String newBalance){
        File userText = new File("src/com/revature/resources/users.txt");
        File writeFile = new File("src/com/revature/resources/users.txt");
        String fullContent = "\n";
        String modified;

        try {
            BufferedReader reader = new BufferedReader((new FileReader(userText)));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                fullContent += line + "\n";
            }
        }
        catch (Exception e) {
            System.err.println("An unexpected exception");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))) {
            modified = fullContent.replaceAll(username + " " + password + " " + balance, newBalance).replaceAll("null", "");
            writer.write(modified);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}
