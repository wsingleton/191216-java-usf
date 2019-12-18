package com.revature;

public class StringDriver {

    public static void main(String[] args) {
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); // true

        s3 = s3.intern(); //string interning - if this object is outside of the string pool it will add it; if one already exists, the reference points to the existing
        System.out.println(s1 == s3); // true, bc it now points to the same object

        /*
        - strings are immutable
        - strings created using String literals are made in the String Pool
        - strings created using the API are made outside of the String Pool but can be added with the intern method {.intern()}

         */
        s2.concat("west");
        System.out.println(s2);

        s2 = s2.concat("west");
        System.out.println(s2);

        String s5 = "Northwest";
        System.out.println(s2 == s5);
        System.out.println(s2.equals(s5));

        String s6 = s2 + "west";
        System.out.println(s2 == s6); // false

        //------------------------------

        /*
            StringBuilder
                -mutable, but not thread safe

            StringBuffer
                - mutable and thread safe
         */

       // StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        System.out.println(sb2 == sb3); // false, separate objects in memory
        System.out.println(sb2.equals(sb3)); // false, b.c the StringBuilder/Buffer classes do not override the implementation of the .equals() method - keeping the original implementation provided by the Object class which is the same exact as ==

        sb2.append(" How's it going?");
        System.out.println(sb2); //StringBuilder is mutable!
        

    }
}
