package com.revature;

import com.revature.models.User;

import java.util.*;

public class CollectionDriver {

    public static void main(String [] args){
        /*
        A set:

        a set is a type of Collection that cannot contain duplicate elements.
        it models the mathematical concept of set abstraction.
         */

        Set<User> userSet = new HashSet<>();
        User u = new User(1, "Wess", "pword5");
        userSet.add(u);
        userSet.add(new User(2, "boss", "hispass"));
        userSet.add(new User(3, "blake", "bpass"));
        userSet.add(u); // this compiles fine but it doesn't add it because it's a duplicate

        for (User user: userSet){
            System.out.println(user);
        }
        System.out.println("+---------------------------------------+");

        /*
         * Queue (Queues are only FIFO)
         *
         * A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide
         * additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws
         * an exception if the operation fails, the other returns a special value (either null or false, depending on the
         * operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue
         * implementations; in most implementations, insert operations cannot fail.
         *
         * For the most part, queues maintain a first-in, first-out order. One exception to this rule is the PriorityQueue
         * implementation, which order elements according to a supplied comparator, or the elements' natural ordering.
         */

        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(u);
        userQueue.add(new User(34, "ervi", "ervpass"));
        userQueue.add(new User(20, "niles", "nilespass"));
        userQueue.add(u); // duplicates are allowed in the queue;

        for(User user: userQueue){
            System.out.println(user);
        }
        System.out.println("+---------------------------------------+");

        /*
        DEQUE

        Deque are simply double ended queues, which expose add, poll, .... operations on both end of the structure.
         */

        Deque<User> userDeque = new ArrayDeque<>();
        userDeque.add(u);

        for (User user: userDeque){
            System.out.println(user);
        }


        /*
        MAP

        Map is a data structure that maps keys to values, conceptually similar to a dictionary (esp. in python).

        in maps, when you declares same values, the latest value declaration will override the previous one.
         */

        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("students", "classes");
        credentialsMap.put(null, ""); // nulls keys are allowed but they must be unique.
        credentialsMap.put("bobo", "google");

        // mapping with many parameters and values
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(14, u);

        // you cannot iterate over a map directly. You have to convert entries using iterators before using while or for loops
        Iterator<Map.Entry<String, String>> mapEntries = credentialsMap.entrySet().iterator();
        while (mapEntries.hasNext()){
            Map.Entry<String, String> entry = mapEntries.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }





    }
}
