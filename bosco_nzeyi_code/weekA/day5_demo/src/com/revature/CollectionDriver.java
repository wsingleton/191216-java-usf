package com.revature;

/*
Collection API follow the following diagram:

                                            Iterable
                                                |
                                            Collection

                                            /    |    \
                                       List    Set   Queue (FIFO)
                                                       ^
                                                       |
                                                     Deque (LIFO)
In List: We have ArrayList, LinkedList, Vectors, and Stacks.
in sets we have: hashSet, TreeSet.
In Queue we have: Priority Queue,

In Deck: ArrayDeque.

------------------------------------------------------------------------

/*
		 * List
		 *
		 * A List is an ordered collection (sometimes called a sequence). Lists may contain
		 * duplicate elements. In addition to the operation inherited from Collection, the
		 * List interface includes operations for the following actions:
		 *
		 * 		+ Positional access
		 * 			- manipulates elements based on their numerical position in the list, which
		 * 			  includes methods such as get, set, add, addAll, and remove
		 *
		 * 		+ Searching
		 * 			- searches for a specified object in the list and returns its numerical
		 * 			  position, methods include: indexOf and lastIndexOf
		 *
		 * 		+ Iteration
		 * 			- List extends Collection, which extends Iterable, and therefore is provided
		 * 			  a iterator() method; listIterator
		 *
		 * 		+ Range-view
		 * 			- The sublist method performs arbitrary range operations on the list
		 *
		 * The Java platform contains two general-purpose List implementations. ArrayList, which
		 * performs well when searching for values, and LinkedList which performs well when adding
		 * or removing elements from the data structure


		 Link: https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html

 */


import com.revature.models.Cat;

import java.util.ArrayList;

public class CollectionDriver {

    public static void main (String [] args){

        ArrayList objects = new ArrayList();
        objects.add("Test");
        objects.add(new Cat());
        objects.add(1);

        ArrayList<String> strings = new ArrayList<>();

        strings.add("try");
        strings.add("other test");

        // for each method to iterate over 


    }
}
