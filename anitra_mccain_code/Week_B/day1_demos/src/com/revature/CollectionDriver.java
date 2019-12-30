package com.revature;

import com.revature.models.User;

import java.util.*;

public class CollectionDriver {

    public static void main(String[] args) {

        /*
        Set

            A set is a Collection that cannot contain duplicate elements. It models the mathmatical concept of set
            abstraction. The Set interface contains only methods inherited from the Collection interfaces and adds the
            restriction that duplicates prohibited. Set implementations also add a stronger contract on the behaviors
            of the equals() and hashCode operations, allowing Set instances to be compared meaningfully even if their
            implementations differ. Lastly, it is important to note that Sets have no implicit ordering.
         */

        Set<User> userSet = new HashSet<>();
        User u = new User(1, "username", "p4ssword");
        userSet.add(u);
        userSet.add(new User(2,"username2", "p4ssword"));
        userSet.add(new User (3, "username3", "roll-tide"));
        userSet.add(u); // this compiles fine, but it just doesn't add this duplicate.

        for(User user: userSet) {
            System.out.println(user);
        }

        System.out.println("+------------------------------------------+");

        /*
          Queue
            A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide
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
        userQueue.add(new User(32, "User4", "Password123"));
        userQueue.add(new User(33, "User5", "Password123"));
        userQueue.add(new User(34, "User6", "Password123"));

        for (User user : userQueue) {
            System.out.println(user);
        }

        System.out.println("+-------------------------------------------------+");

        while ( userQueue.peek() != null) {
            System.out.println("Queue size: " + userQueue.size());
            System.out.println("Processing value: " + userQueue.poll());
        }

        /*
        * Deques are simply "double-ended" queues, which expose add, poll, and peek operations on both ends of the structure.
        * */
        Deque<User> userDeque = new ArrayDeque<>();


        System.out.println("+----------------------------------------------------+");

        /*
        * Map
        *   A data structure that "maps" keys to values, conceptually similar to a dictionary (esp. in Python)
        *
        *   -cannot have duplicate keys (one key can map to, at most, one value)
        *   -In most implementations, keys are allowed to be null (as long as there is only one)
        *   - Values do not have to be unique
        * */

        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("username", "p4ssword");
        credentialsMap.put(null, ""); //null keys are fine, but they must be unique
        credentialsMap.put("username", null); // no issue with null values
        credentialsMap.put("username", null); // values have no uniqueness restriction
        credentialsMap.put("username", "betterp4assword"); // this will override the previous value
        credentialsMap.put(new String("username"), "hi"); //also overrides the previous value

        // you can mix types (note that primitive data types are not permitted)
        Map<Integer, User> userMap = new HashMap<>();
       // Map<int, User> doesntWork = new HashMap<>(); broken

        System.out.println(credentialsMap.get("username"));

        //You cannot iterate directly across a map, however...
        Iterator<Map.Entry<String, String>> mapEntries = credentialsMap.entrySet().iterator();

        while(mapEntries.hasNext()) {
            Map.Entry<String, String> entry = mapEntries.next();
            System.out.println("Key: "+ entry.getKey() + ", Value: " + entry.getValue());
        }


    }
}
