package practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    final static String fileLocation = "src/practice/users.txt";

    void addAccount(Account a){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))) {

//            Account a = new Account("Bruce", "rconnell", 90);
            writer.write("\n" + a.toFileString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Account> readAccount(){
        List<Account> accountsList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String userLine = reader.readLine();

            while (userLine !=null){
                String[] userFields = userLine.split(":");
                Account a = new Account(userFields[0],userFields[1],(Integer.parseInt(userFields[2])));
                accountsList.add(a);
                userLine = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected error occured");
        }
        for(Account a : accountsList) System.out.println(a);

        return accountsList;
    }


    public void updateAccount(ArrayList<Account> accountsList){
        //make sure it gets written over
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation,false))){
            for (int i=0; i<accountsList.size(); i++){
                writer.write(accountsList.get(i).toString());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

