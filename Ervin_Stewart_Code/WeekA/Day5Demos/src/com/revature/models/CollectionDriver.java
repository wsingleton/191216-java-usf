package com.revature.models;

import java.util.ArrayList;

public class CollectionDriver {
    public static void main(String... args){
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


        //Raw collection (without
        ArrayList objects = new ArrayList();
        objects.add(new Cat());
        objects.add("test");
        objects.add(1);
        String s = (String) objects.get(0);
        //String ss = (String) objects.get(1); //throws ClassCastException


        ArrayList<String> strings = new ArrayList<>();
        strings.add("test");
        //strings.add(new Cat());//generics have provided us with TYPE Saftey!
        strings.add("test");// duplicates are allowed in lists

        //All collections are iterable, can be used with a for-each loop
        for(String val: strings){
            System.out.println(val);
        }

    }
}
