package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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


}
