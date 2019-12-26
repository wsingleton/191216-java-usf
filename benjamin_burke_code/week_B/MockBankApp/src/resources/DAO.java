package resources;

import com.revature.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DAO {

    final static String file = "src/resources/users.txt";

    void addUser(User u) {
        //need to write user to file
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(file, true)))) {
           writer.write(u.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> readUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try(BufferedReader b = new BufferedReader(new FileReader(file))){
            //hmmm trying to create
            String line = null;
            while ((line=b.readLine()) !=null) {
                String[] data = line.split(":");
                User temp = new User();
                temp.setUsername(data[0]);
                temp.setPassword(data[1]);
                users.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}

