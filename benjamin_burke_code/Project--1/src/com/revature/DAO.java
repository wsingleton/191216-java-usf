package com.revature;

import com.revature.models.User;

import java.io.*;
import java.util.ArrayList;

import static com.revature.Service.addUser;

public class DAO {
    private final static String fileLocation = "src/com/revature/Users.txt";

    /*
        Even though I added the file manually lets create a method
        to create an empty users.txt if it isn't already there
     */

    static {
        File file = new File(fileLocation);
        boolean fileExists = file.exists();
        if(!file.exists()){
            try {
                fileExists = file.createNewFile();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        if(fileExists) System.out.println("The file exists!");
        else System.out.println("no users.txt");
    }

    static public ArrayList<User> readAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
            String line = null;
            while((line=br.readLine()) !=null){
                String[] data = line.split(":");
                //I think i will need to create a constructor....
                User temp = new User(data);
                list.add(temp);
            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    static void syncUsers(ArrayList<User> list){
        cleanup();
        for(User u : list ) {
                addUser(u);
        }
    }

    static void cleanup(){
        try {
            PrintWriter ps = new PrintWriter(fileLocation);
            ps.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
