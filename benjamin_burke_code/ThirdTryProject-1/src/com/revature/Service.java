package com.revature;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

public class Service {
    static ArrayList<User>users;
    static {
        users = new ArrayList<User>();
        users.add(new User("benji", "password", 0));
    }

    ArrayList<User> getAllUsers(){
        DAO dao = new DAO();
        ///need a read users from text file
        return dao.readUsers();
    }

    boolean exists(String username){
        ArrayList<User> users = getAllUsers();
        return users.stream().anyMatch(u ->u.getUsername().equalsIgnoreCase(username));
    }

}
