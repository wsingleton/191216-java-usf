package com.revature;



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

import java.util.ArrayList;

public class CollectionDriver {
    public static void main(String args){
        ArrayList object = new ArrayList();
        object.add("dasdas");
        object.add(1);

        String s = (String)object.get(0);

        ArrayList<String> str = new ArrayList<>();
        str.add("test1");
        str.add("test2");
        str.add("test3");
        str.add("test"); // dupe are allow
        for (String val : str){
            System.out.println(val);
        }
    }

}
