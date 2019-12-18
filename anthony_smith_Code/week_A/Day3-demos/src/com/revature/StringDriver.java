package com.revature;



public class StringDriver {

    public static void main (String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;
        /*
            when comparing objecs, == is used to check for memory location
            equivalance
         */
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        /*
            String interning is the act og moving a string object - which
            exists outside of the string pool - and "interning" or moving
         */

        s3 = s3.intern();

        System.out.println(s1 == s3); // true

        s2.concat("west");
        System.out.println(s2);

        s2 = s2.concat("west");
        System.out.println(s2);

        String s5 = "Northwest";
        System.out.println(s2 == s5); // false

       // StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello");
        StringBuilder sb3 = new StringBuilder("Hello");

        System.out.println(sb2 == sb3); // false

    }
}
