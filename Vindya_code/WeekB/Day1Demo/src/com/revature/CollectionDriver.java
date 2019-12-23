package com.revature;

import com.revature.models.User;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CollectionDriver {
    public static void main(String[] args) {

    }
    /*
    set
    A set is a collection  that can not contain duplicate elements.
    It models the mathematical concept of set abstarction. The set interface contains
    only mebers inherited from the collection interface and adds the restriction that duplicates prohibited,
    Set implecations also add a
    stronger contract on the behaviour of the equals() and hashcode () operators,
    allowing set instances to be compared meaningfully even if their implementation differ.Lastly
     */
    Set<User> userset =new HashSet<>();
    User u = new User(1,"wsingleton","password");

    UserSet.add(u);
    UserSet.add(new User(2,"skelsy", "password"));
    UserSet.add(new user(3,"rconnell","roll_tide"));
    UserSet.add(u);// this compiles fine, but it just doesn't add this duplicates

for (User user:userSet){
    System.out.println(User);
}
System.out.println("+................+");

}
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
UserQueue.add(u);
UserQueue.add(new user(34,"bkruppa","javascript"));
userQueue.add(new user(34,"njurkkh","microservices"));
userqueue.add(new user(93,"njurczak","microservices"));
userQueue.add(add(u));
System.out.println("+,,,,,,,+");

while(!userQueue.isEmpty()){
        System.out.println("Queue size:"+userQueue.size());
        System.out.println("processing value:"+userQueue.poll());
        }
*/Dequeue are simply "double-ended"queues, which expose add,poll, and peek
operations on both ends of the structure.class*/

Deque<user>userDeque=new ArrayDeque<>();
Sytem.out.println("+......+");
/*

 */
 Map




