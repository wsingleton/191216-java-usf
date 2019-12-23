package com.revature;

import com.revature.models.User;

import java.util.*;

public class CollectionDrive {
    public static void main(String... args){
        /*
        Set

        A set is a collection that cannot contain duplicate elements. It models the mathematical concept of set abstraction.
        the set interface contains only methods inherited from the Collection interfaces and adds the restriction that
        duplications prohibited. Set implementations also add a stronger contract on the behaviors of the equals() and hashcode()
        operations, allowing Set instruction to be compared meaningfully even if their implementations differ. Lastly, it is
        important to not
        -uniqueness is enforced, no inherent order, no way to get a particular item at a particular point

         You would use a set over a list, when you don't ned positional access, a particular order

        Queue
         *
         * A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide
         * additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws
         * an exception if the operation fails, the other returns a special value (either null or false, depending on the
         * operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue
         * implementations; in most implementations, insert operations cannot fail.
         *
         * For the most part, queues maintain a first-in, first-out order. One exception to this rule is the PriorityQueue
         * implementation, which order elements according to a supplied comparator, or the elements' natural ordering.
         ordered, no positional access, first in first out order

        Map
            An data structure that "maps" keys to values, conceptually similar to a dictionary (esp. in Python).

            -cannot have duplicate keys(one key can map to, at most, one value)
            -in most implementations, keys are allowed to be null (as long as their is only one
            -values do not have to be unique
         */
        Map<String, String> credentialsMap = new HashMap<>();
        credentialsMap.put("Spacemvn", "estew84@");
        credentialsMap.put(null, "");//null keys are fine, but they must be unique
        credentialsMap.put("Spacemvn", "estew84@");// no issue with null values
        credentialsMap.put("skelsey", null);//values have no uniquenss restriction
        credentialsMap.put("Spacemvn", "1epuribusfungo@");// this will override the previous value
        credentialsMap.put(new String("Spacemvn"), "hi");// also overrides the previous value
// if you mix types(note that primitive data types are not permitted)
        Map<Integer, User> userMap = new HashMap<>();
//      Map<int, User>userMap = new HashMap<>(); // broken

        System.out.println(credentialsMap.get("Spacemvn"));

        // you cannot iterate across a map, however ...
        Iterator<Map.Entry<String, String>> mapEntries = credentialsMap.entrySet().iterator();

        while(mapEntries.hasNext()){
            Map.Entry<String, String> entry = mapEntries.next();
            System.out.println("Key: "+ entry.getKey() + ", Value: " + entry.getValue());
        }




        Set<User> userSet = new HashSet<>();
        User u = new User(45876987, "Spacemvn", "estew84@");
        userSet.add(u);
        userSet.add(new User(2,"unitard 777","tmacl34@"));
        userSet.add(new User(3,"EbonyFalconx","cjack64@"));
        userSet.add(new User(45873216,"SimplictySk8","bkuzn24@"));
        userSet.add(u);//this compiles fine but it just doesn't add ths duplicate

        for( User user: userSet){
            System.out.println(user);
        }
        System.out.println("+--------------------------------------------+");


        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(u);
        userQueue.add(new User(6,"Detroyer47", "password"));
        userQueue.add(null);
        userQueue.add(u);

    while(!userQueue.isEmpty()){
    System.out.println("Queue size: "+ userQueue.size());
    System.out.println("processing value: "+ userQueue.poll());
    }
    /*
    deques are simply double ended queues, which expose add, poll,
    and peek operations on both ends of the structure.
     */
    Deque<User> userDeque = new ArrayDeque<>();
    }
}

