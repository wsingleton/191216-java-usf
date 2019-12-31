package com.revature;

import com.revature.models.User;

import java.util.*;

public class CollectionDriver {

    public static void main(String[] args) {

        /*
            Set

                A Set is a Collection that cannot contain duplicate elements. It models
                the mathematical concept of set abstraction. The Set interface contains
                only methods inherited from the Collection interfaces adn adds the
                restriction that duplicates prohibited. Set implementations also add a
                stronger contract on the behaviors of the equals() and hashCode() operations,
                allowing Set instances to be compared meaningfully even if their implementations
                differ. Lastly, Sets have no implicit ordering.

         */

        Integer[] myArray = {1, 2, 3};
        List<Integer> myList = Arrays.asList(myArray);



        Set<User> userSet = new HashSet<>();
        User u = new User(1, "ehsi", "p4ssw0rd");
        userSet.add(u);
        userSet.add(new User(2, "jakewi", "password"));
        userSet.add(new User(3, "econraddiao", "p4ssword"));
        userSet.add(u);
        userSet.forEach((v) -> System.out.println(v));
    }
}
