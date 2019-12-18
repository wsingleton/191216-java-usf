package com.revature;

public class StringDriver {

    public static void main(String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        System.out.println(s1 == s2); // this will print true
        System.out.println(s1 == s3); // this prints false because a variable is being compared with an object.
        System.out.println(s1.equals(s3)); // prints true because we are comparing if all the objects are refers to the same value

        /*
        for s3 we created a different String object. It takes so much space rather than simply declaring it as a string.
        we can add it to other normal string pools and delete that object.
        we use intern() method.
         */
        s3.intern();
        System.out.println(s1 == s3); // now true because it now points to the same objects as other strings in the string pool

        // String values are immutable. they can't be changed. When you concat or reference the same string with a new value, a new string is created
        // with the same value instead of assigning the string with a new value.
        // eg:
        s2.concat(" West"); // this will not concatenate north with west. A new string will be created for west.
        System.out.println(s2);

        s2 = s2.concat(" West"); // this create a new string object that is concatenated.
        System.out.println(s2);

    }
}
