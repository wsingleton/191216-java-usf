package com.company;

import java.util.*;

public class Logon {

    public static void main(String[] args) {


        Set<User> userSet = new HashSet<>();
        User u = new User(1, "swright", "p4ssw0rd");
        userSet.add(u);
        userSet.add(new User(2, "sjames", "password"));
        userSet.add(new User(3, "jsermans", "seminoles"));
        userSet.add(new User(13, "test", "test-pw"));
        userSet.add(u);

        for (User user : userSet) {
            System.out.println(user);
        }

        System.out.println("+------------------------+");


        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(u);
        userQueue.add(new User(33, "ckarthur", "javascript"));
        userQueue.add(new User(33, "ckarthur", "javascript"));
        userQueue.add(new User(92, "bjurczak", "microservices"));
        userQueue.add(null);
        userQueue.add(u);


        for (User user : userQueue) {
            System.out.println(user);
        }

        System.out.println("+---------------------+");

        while (!userQueue.isEmpty()) {
            System.out.println("Queue size: " + userQueue.size());
            System.out.println("Processing value: " + userQueue.poll());
        }


        Deque<User> userDeque = new ArrayDeque<>();

        System.out.println("+---------------------+");


        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("wsingleton", "p4ssw0rd");
        credentialsMap.put(null, ""); // null keys are fine, but they must be unique
        credentialsMap.put("skelsey", null); // no issue with null values
        credentialsMap.put("bkruppa", null); // values have no uniqueness restriction
        credentialsMap.put("wsingleton", "b3tt3rp4ssw0rd"); // this will override the previous value
        credentialsMap.put(new String("wsingleton"), "hi"); // also overrides the previous value


        // you can mix types (note that primitive data types are not permitted
        Map<Integer, User> userMap = new HashMap<>();
//        Map<int, User> doesntWork = new HashMap<>(); // broken


        System.out.println(credentialsMap.get("wsingleton"));

        // you cannot iterate directly across a map, however...
        Iterator<Map.Entry<String, String>> mapEntries = credentialsMap.entrySet().iterator();

        while (mapEntries.hasNext()) {
            Map.Entry<String, String> entry = mapEntries.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }


}
