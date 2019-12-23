package com.revature;

import com.revature.model.User;

import java.util.*;

public class CollectionDriver {
    public static void main(String[] args){
        /*
        set

            a set is a collection that cannot contain duplicate elements, it models the mathematical conceptt of set abstraction. The set interface contains only
            methods inherited from the Collection interface and adds the restiction that duplicates prohibited. Set implementations also add a stronger contract on the behavior of the
            equals() and hashCode() operations,
            allowing Set instances to be compared meaning fully even if their implemetation
            differ,. LAstly , it is important to note that Set have no implicit ordering


         */
        Set<User> userSet = new HashSet<>();

        User u = new User(1, "wsingletin", "password");
        userSet.add(u);
        userSet.add(new User(2,"hoang","pass"));
        userSet.add(new User(2,"robert","roll_tile"));
        userSet.add(new User(13,"test","test-pw"));
        userSet.add(u);// this compiles fine, but it just dosesnt add this duplicate


        for (User user : userSet){
            System.out.println(user);
        }

        System.out.println("---------------------------------------");

        /*

            Queue
                    * A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide
                    * additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws
                    * an exception if the operation fails, the other returns a special value (either null or false, depending on the
                    * operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue
                    * implementations; in most implementations, insert operations cannot fail.
                    * For the most part, queues maintain a first-in, first-out order. One exception to this rule is the PriorityQueue
                    * implementation, which order elements according to a supplied comparator, or the elements' natural ordering.

         */

        Queue<User> userQueue = new LinkedList<>();

        userQueue.add(u);
        userQueue.add(new User(34,"asdasd", "java"));
        userQueue.add(new User(34,"asdasd", "java"));
        userQueue.add(new User(93,"gdaddsasd", "javaaaaaa"));
        userQueue.add(new User(34,"asdasd", "java"));
        userQueue.add(null);
        userQueue.add(u);
        for (User user : userQueue){
            System.out.println(user);
        }

        while(userQueue.isEmpty()){
            System.out.println("queue size" + userQueue.size());
            System.out.println("process value "+ userQueue.peek());
        }


        /*
            deques are smply "double-ended" queues, which expors add , poll ,
             and peek operations on both ends of the structure
         */

        Deque<User> userDeque = new ArrayDeque<>();


        System.out.println("----------------------------");
        /*

        Map
            An data structure that "maps" key to values, conceotually similar to
            a dictionary (esp in python)

           - cannot have duplicate keys (one key can map to , at most , one value)
           - in most implementations, keys are allowed to be null (as long as there is only one )
           - value do not have to be unique

         */

        Map<String,String> credentialsMap = new HashMap<>();
        credentialsMap.put("wsingleton", "pass");
        credentialsMap.put(null,"");// null are fine, but they mist be unique
        credentialsMap.put("asdasd",null);
        credentialsMap.put("fffff",null);
        credentialsMap.put("wsingleton", "badasdsa");
        credentialsMap.put(new String("wsingleton"), "hi");// also overrides the previous value


        // you can mix types (note that primitice data types are not permitted)
        Map<Integer,User> userMap  = new HashMap<>();
        //Map<int.user > do not work

        System.out.println(credentialsMap.get("wsingleton"));

        // you cant iterate directly across a map, however ...

        Iterator<Map.Entry<String,String>> mapEntries = credentialsMap.entrySet().iterator();

        while(mapEntries.hasNext()){
            Map.Entry<String,String> entry = mapEntries.next();
            System.out.println(("key: "+ entry.getKey() + ", Value: " + entry.getValue()));
         }








    }
}
