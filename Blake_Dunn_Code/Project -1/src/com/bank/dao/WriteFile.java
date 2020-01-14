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

            writer.close();

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

    public static void replaceBalance(String oldAcctNum, String oldAcctBal, String newAcctNum, String newAcctBal) {

        File acctFile = new File("src/resources/account.txt");


        String fullContent = "\n";


        try {
            BufferedReader reader = new BufferedReader(new FileReader(acctFile));

            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();

                fullContent += line + "\n";

            }


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(acctFile))) {

                String modified = fullContent.replaceAll(oldAcctNum + ":" + oldAcctBal, newAcctNum + ":" + newAcctBal).replaceAll("null", "");
                writer.write(modified);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }catch (NullPointerException np1) {

        } catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}