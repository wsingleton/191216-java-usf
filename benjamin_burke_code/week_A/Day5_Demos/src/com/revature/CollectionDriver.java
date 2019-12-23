package com.revature;

import java.util.ArrayList;

public class CollectionDriver {
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
     */

    //Raw collections without the use of generics) - anything in an object, always
    ArrayList objects = new ArrayList();
    objects.add("test");

   ArrayList<String> Strings = new ArrayList<>();
   Strings.add("test");
   // Strings.add(new cat()) // generics have provided us with the Saftey
    string.add("");

}
