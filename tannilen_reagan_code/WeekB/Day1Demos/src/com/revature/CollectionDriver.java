package com.revature;
import com.revature.models.User;
import java.util.*;

public class CollectionDriver {
    public static void main(String[] args) {
        Set<User> userSet = new HashSet<>();
        User instructor = new User(1, "WSingleton", "wezley@revature");
        userSet.add(instructor);
        userSet.add(new User(2, "SWright", "steve@revature"));
        userSet.add(new User(3, "TReagan", "tannilen@revature"));
        userSet.add(new User(4, "AMcCain", "anitra@revature"));
        userSet.add(new User(5, "JWolf", "jeremiah@revature"));
        userSet.add(new User(6, "DAllen", "dayvon@revature"));
        for (User u : userSet) {
            System.out.println(u);
        }
        System.out.println("+------------------------------------------------------------+");
        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(instructor);
        userQueue.add(new User(2, "SWright", "steve@revature"));
        userQueue.add(new User(3, "TReagan", "tannilen@revature"));
        userQueue.add(new User(4, "AMcCain", "anitra@revature"));
        userQueue.add(new User(5, "JWolf", "jeremiah@revature"));
        userQueue.add(new User(6, "DAllen", "dayvon@revature"));
        for (User u : userQueue) {
            System.out.println(u);
        }
        System.out.println("+------------------------------------------------------------+");
        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("WSingleton", "Welcome2Rev");
        credentialsMap.put("SWright", "Welcome2Rev");
        credentialsMap.put("TReagan", "Welcome2Rev");
        credentialsMap.put("AMcCain", "Welcome2Rev");
        credentialsMap.put("JWolf", "Welcome2Rev");
        credentialsMap.put("DAllen", "Welcome2Rev");
        credentialsMap.put("WSingleton", "P4ssw0rd^d@te");
        System.out.println(credentialsMap.get("WSingleton"));
        //How to iterate across a map:
        Iterator<Map.Entry<String,String>> mapEntries = credentialsMap.entrySet().iterator();
        while(mapEntries.hasNext()) {
            Map.Entry<String,String> entry = mapEntries.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
