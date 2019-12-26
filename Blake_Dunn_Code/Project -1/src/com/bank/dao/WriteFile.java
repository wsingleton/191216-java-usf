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

    public static void replaceBalance(Account acct) {

        File acctFile = new File("src/resources/account.txt");
        File tempFile = new File("src/resources/temp.txt");


        int acctNumber = acct.getiD();
        String acctNum = Integer.toString(acctNumber);


        try {
            BufferedReader reader = new BufferedReader(new FileReader(acctFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                String[] token = line.split(":");
                if(token[0].equals(acctNum)){

                }else {
                    writer.write(token[0] + ":" + token[1] + ":" + "\n");
                }
            }
            writer.write("\n" + acct.toFileStringAccount());

            writer.close();
            reader.close();

            acctFile.delete();
            tempFile.renameTo(acctFile);

        }catch (NullPointerException np1) {

        } catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
