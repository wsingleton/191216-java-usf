package com.revature;
import com.revature.models.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFileDriver {
public static void main(String... args){

    File writeFile = new File("src/resources/user.txt");

    // try-with-resources (introduced in java 7) :: auto-closes objects declared as
    // resources only allows for the instantiation of objects that implement auto-closeable interface
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile,true))){
        User  newUser = new User(48751584,"Epluribusfungo","Joymemom231");
        writer.write("\n"+ newUser.toFileString());
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
