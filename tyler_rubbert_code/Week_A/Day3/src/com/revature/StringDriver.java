package com.revature;


public class StringDriver {

    public static void main(String[] args) {
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            When comparing objects, == is used to check for memory location equivalence.

            To compare the field values of objects, you should use the
            .equals
         */
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); // true

        /*
            String interning is the act of moving a String object - which
            exists outside of the String Pool -- and "interning" or moving it into the string pool
         */
        s3 = s3.intern();
        System.out.println(s1 == s3); // true

        /*
            -Strings are immutable
            -String created use String literals are made w/in the String pool
            -Strings created use the String constructor, String API methods, or
             by concatenations are always created OUTSIDE of the String pool
         */
        s2.concat("west");
        System.out.println(s2);

        s2 = s2.concat("west");
        System.out.println(s2);

        String s5 = "Northwest";
        System.out.println(s2 == s5); //false

        String s6 = s2 + "west";
        System.out.println(s2 == s6);

        //--------------------------------------------------------------------

        /*
            StringBuilder
                - mutable
                - not thread-safe

            StringBuffer
                - mutable
                - thread-safe
         */

//        StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        /*
            The StringBuilder/Buffer classes do not override the implementation of the
            .equals() method - keeping the original implementation provided by the
            Object class, which is the exact same as ==
         */
        System.out.println(sb2 == sb3); // false
        System.out.println(sb2.equals(sb3)); // false

        sb2.append(" How's it going?");
        System.out.println(sb2); // StringBuilder is mutable!

    }
}
