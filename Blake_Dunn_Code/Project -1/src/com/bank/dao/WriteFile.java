package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.*;

import static com.bank.ui.UserScreen.display;

public class WriteFile {

    public static void writeToUser(User newUser) {

        File writeFile = new File("src/resources/users.txt");

        //try-with-resources (introduced in Java 7) :: auto-closes objects declared as resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))) {

            writer.write("\n" + newUser.toFileStringUser());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeToAccount(Account newAcct) {

        File writeFile = new File("src/resources/account.txt");

        //try-with-resources (introduced in Java 7) :: auto-closes objects declared as resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))) {

            writer.write("\n" + newAcct.toFileStringAccount());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void replaceBalance(Account newBalanceAcct) {

        File acctFile = new File("src/resources/account.txt");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(acctFile));
            String line = reader.readLine();
            String newBalance = newBalanceAcct.toString();
            String[] newStringArray = new String[newBalance.length()];

            while (line != null) {
                line = reader.readLine();
                String[] token = line.split(":");
                if(token[0].equals(newStringArray[0])){
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(acctFile, true))) {
                        String line2 = reader.readLine();
                        String[] token2 = line2.split(":");
                        if(token2[0].equals(newStringArray[0])){
                        line2 = line2.replace(token[1], newStringArray[1]);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

        }catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
