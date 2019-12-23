package com.revature;

import com.revature.models.User;

import java.util.*;

public class CollectionDriver {

    public static void main(String[] args) {
        /*
        Set
         is a collection that can contain duplicate elements. I t models the mathematical concept of set abstraction.
         The set interface contains only methods inherited from the collection interfaces and adds the structuin that
         duplicates are prohibited.
         Set implementations also add a stronger contract on the behaviors of the equals() and hashCode() operations,
          allowing set instances to be compared meaningfully even if their implemntation differs.
         */
        Set<User> userSet = new HashSet<User>();

        User u = new User("Pass", "D", 1);
        userSet.add(u);
        userSet.add(new User("Kell", "mame", 3));

        for (User user : userSet){
            System.out.println(user);
        }

        System.out.println("+----------------------------------------+");

        /*
         * Queue
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
        userQueue.add(new User("John", "cake", 3));
        userQueue.add(new User("larry", "helping", 5));
        userQueue.add(u);

        for (User user : userQueue){
            System.out.println(user);
        }

        System.out.println("+----------------------------------------+");

         while(!userQueue.isEmpty()){
             System.out.println(userQueue.size());
             System.out.println(userQueue.poll());
         }
         /*
         deques are simply double ended queues that expose add, poll, peek
          */

//        Deque<User> userDeque = new ArrayDeque<>();

        /*
        Maps - a data structure that maps keys to values, conceptually similar to a dictionary especially in python.
        a map cannot have duplicate keys(One key points to one thing)
        -In most implementations keys are allowed to be null(as long as there is only one)
        Values do not have to be unique
         */

        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("Jsmith", "P4ssword");
        credentialsMap.put(null, "");
        credentialsMap.put("skelksy", null);
        credentialsMap.put("Bkruppe", null);

        System.out.println(credentialsMap.get("Jsmith"));

        Iterator<Map.Entry<String, String>> mapEntries = credentialsMap.entrySet().iterator();

        while(mapEntries.hasNext()){
            Map.Entry<String, String> entry = mapEntries.next();
            System.out.println(entry.getKey() + "\n" + entry.getValue() + "\n");
        }




    }

}
