package com.revature;

import com.revature.models.User;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.*;


public class CollectionDriver {
    // iterator is at the very top of the collections API - *review  your notes from Friday*
    // Collection is the interface withing the API, Collections is in the
    public static void main(String[] args) {

        /*
        A set is a collection that cannot contain duplicate elements. It models the mathematical concept of abstraction.
        The Set interface contains only methods inherited from the Collection interfaces and adds the restriction that
        prohibits duplicates. Set implementations also add a stronger contract on the behaviors of the equals() and hashCode()
        operations, allowing Set instances to be compared meaningfully even if their implementations
         differ. Lastly is is important to note...
         */

        Set<User> userSet = new HashSet<>();
        User u = new User(1, "ndiggs", "p4ssw0rd");
        userSet.add(u);
        userSet.add(new User(2, "skelsey", "password"));
        userSet.add(new User(3, "rconnell", "roll-tide"));
        userSet.add(new User(13, "test", "test-pw"));

        userSet.add(u); // this compiles fine, but it doesn't add this duplicate

        for (User user : userSet) {
            System.out.println(user);
        }

        System.out.println("--------------------------------");
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
        userQueue.add(u);
        userQueue.add(new User(34, "bkruppa", "javascript"));
        userQueue.add(new User(34, "brkuppa,", "javascript"));


        // Deques are simply double ended queues, which expose add, poll and peek, operations on both ends of the structure

        Deque<User> userDeque = new ArrayDeque<>();

        System.out.println("------------------------");


        /*

        Map

             a data structure that "maps" keys to values, conceptually similar to a dictionary.

             - Cannot have duplicate keys (one key to can map to, at most, on value)
             -In most implementations, keys are allowed to be null (as long  as there is only one)
             - Values do not have to be unique
         */

        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("ndiggs", "p4ssw0rd");
        credentialsMap.put(null, ""); // null keys are fine but must be unique
        credentialsMap.put("skelsey", null); //no issues with null
        credentialsMap.put("bkruppa", null); // values have no uniqueness restriction
        credentialsMap.put("ndiggs", "anotherpassword"); // this will override the previous value


        // you can mix types but they must be generic, primitive types are not allowed
        Map<Integer, User> userMap = new HashMap<>();
        //

        System.out.println(credentialsMap.get("ndiggs"));

        // you cannot interate directly across a map, but you can do this....
        Iterator<Map.Entry<String, String>> mapEntries = credentialsMap.entrySet().iterator();

        while (mapEntries.hasNext()) {
            Map.Entry<String, String> entry = mapEntries.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        } // can also use an enhanced for loop, for each entrySet do something...

    }
}






