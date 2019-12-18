package com.revature;

//import static java.lang.System.out; similar to using namespace c++

public class StringDriver {

    public static void main(String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String ("North");
        String s4 = null;

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); //true

        s3 = s3.intern(); // moves the object to the string pool.
        /* If the object already exists in the heap, the reference
            is relocated to the obj that already exists.
            The same obj that exist outside the string pool will be
            deleted by java garbage collector, thus freeing memory space.
        * */
        System.out.println(s1 == s3); //true (because it now points to the same object)

        /*
        * s2.concat creates the obj "Northwest" but nothing is pointing to it.
        *
        * */

        s2.concat("west");
        System.out.println(s2);

        s2 = s2.concat("west"); //created outside the sting pool
        System.out.println(s2);

        String s5 = "Northwest"; //created inside the string pool
        System.out.println(s2 == s5); //false different reference points

        String s6 = s2 + "west";
        System.out.println(s2 == s6); //false

      //  out.println();
      //-----------------------------------------------------------------------
        /*
            StringBuilder
                - mutable
                - not thread-safe

            StringBuffer
                - mutable
                - thread-safe
         */

        //StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        System.out.println(sb2 == sb3); //false
        System.out.println(sb2.equals(sb3)); //false

        sb2.append("How's it going?");
        System.out.println(sb2); // StringBuilder is mutable
    }

}
