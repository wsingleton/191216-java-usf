package com.revature;
import com.revature.models.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFileDriver {
public static void main(String... args){
 int id = 35344336;
 String Username = "Estewa20";
 String password = "newPassword";

    WriteToFile(id,Username,password);
}

    public static void WriteToFile( int id, String username, String password) {
        File writeFile = new File("src/resources/user.txt");

        // try-with-resources (introduced in java 7) :: auto-closes objects declared as
        // resources only allows for the instantiation of objects that implement auto-closeable interface
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile,true))){
            User newUser = new User(id,username,password);
            writer.write("\n"+ newUser.toFileString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
