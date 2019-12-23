package com.revature;

import com.revature.models.User;

import java.util.*;

public class CollectionDriver {

    public static void main(String[] args) {

        /*
            Set

                A Set is a collection that cannot contain dupliate elements.
                It models the mathemarical concept of set abstraction. The set interface
                contains only methods inherited from the Collection interfaves and adds the restriction that duplicated prohibited.
                Swt implementations also add a stronger contract on the behaviors
                of the equals() and hashCode() operations, allowing Set
                instances to be compared meaningfully even if their implementations differ
                Lastly, it is i,portant to note that sets have no pmplicit ordering.

         */

        Set<User>  userSet = new HashSet<>();
        User u = new User(1, "wsingleton", "p4ssw0rd");
        userSet.add(u);
        userSet.add(new User(2, "skelsey", "password"));
        userSet.add(new User(2, "rconnell", "roll-tide"));
        userSet.add(u); // this compiles fine, but it just doesn't add this duplicate

        for (User user : userSet) {
            System.out.println(user);

        }

        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(u);
        userQueue.add(new User(34, "bkruppa", "javascript"));
        userQueue.add(new User(93, "njurczak", "javascript"));
        userQueue.add(u);

        for (User user : userQueue) {
            System.out.println(user);
        }


        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("wsingleton", "password");
        credentialsMap.put(null, ""); //null keys are fine, but they must be unique
        credentialsMap.put("skelly", null); //no issue with null values
        credentialsMap.put("bkruppa", null); //values have no uniqueness restriction
        credentialsMap.put("wsingleton", "b3tt3rp4ssw0rd"); // will override the previous
        credentialsMap.put(new String("wsingleton"), "hi"); //also overrides

        //you can mix types (not that primitive data types are not permitted
        Map<Integer, User> userMap = new HashMap<>();



    }

}
