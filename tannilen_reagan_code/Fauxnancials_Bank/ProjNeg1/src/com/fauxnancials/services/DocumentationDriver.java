package com.fauxnancials.services;

import com.fauxnancials.resources.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.lang.Integer.parseInt;

public class DocumentationDriver {
    public static ArrayList<User> CollectUsers() {
        ArrayList<User> usersList = new ArrayList<>();
        File userAccts = new File("src/com/fauxnancials/resources/useraccts.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(userAccts))) {
            String line = null;
            line = reader.readLine();
            while (line != null) {
                String[] userFields = line.split(":");
                User u = new User(userFields[0], Integer.parseInt(userFields[1]));
                usersList.add(u);
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            System.err.println("Exception occurred while reading file.");
            System.err.println(ioe.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
            System.err.println(e.getMessage());
        }
        return usersList;
    }
    public static HashMap<String, Integer> collectAccounts() {
        HashMap<String, Integer> accounts = new HashMap<>();
        File balanceAccts = new File("src/com/fauxnancials/resources/acctbalances.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(balanceAccts))) {
            String line=null;
            line=reader.readLine();
            while (line!=null) {
                String[] acctFields=line.split(":");
                accounts.put(acctFields[0],Integer.parseInt(acctFields[1]));
                line=reader.readLine();
            }
        }
        catch (IOException ioe) {
            System.err.println("Exception occurred while reading file.");
            System.err.println(ioe.getMessage());
        }
        catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
            System.err.println(e.getMessage());
        }
        return accounts;
    }
    public static void updateUsers(ArrayList<User> userList) {
        File userFile = new File("src/com/fauxnancials/resources/useraccts.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            for(User u : userList) {
                writer.write(u.toFileString()+"\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected exception has occurred.");
        }
    }
    public static void updateAccts(HashMap<String,Integer> acctList) {
        File acctFile = new File("src/com/fauxnancials/resources/acctbalances.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(acctFile))) {
            for(Map.Entry<String,Integer> entry : acctList.entrySet()) {
                writer.write(entry.getKey()+":"+entry.getValue()+"\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected exception has occurred.");
        }
    }
}
