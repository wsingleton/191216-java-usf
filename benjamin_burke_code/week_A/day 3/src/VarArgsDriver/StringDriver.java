package VarArgsDriver;


import java.sql.SQLOutput;

public class StringDriver {
    public static void main(String[]arg){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;
        //null means there is nothing there.
        /*
        When comparing oubjects, == is used to check for memory location equivalence.

        To compare the field values
         */

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        /*

        String interning is the act of moving a String object - which exists outside of String pool - and "interning"
        or moving  it into the string pool
         */

        s3 = s3.intern();
        System.out.println(s1 == s3);

        s2 = s2.concat("west");
        System.out.println(s2);

        String s5 = "Northwest";
        System.out.println(s2 == s5);

        String s6 = s2 + "west";
        System.out.println(s2 == s6);


        /*
        Strings are immutable. Strings created using String literals are made within the String Pool
        Strings created by using String api methods,
        are made outside of the string pool for concatonation.
        ->String objects outside of the string pool, can be added into it, by using the intern method.


        StringBuilder vs String Buffer

        StringBuilder
        -> mutable
        -> not thread-safe

        StringBuffer
        ->mutable
        -> thread-safe
         */

        //StringBuilder sb1 = "this does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        /*
        the StringBuilder/Buffer classes do not override the implementation
        of the .equals() method - keeping the original implemntation provided by
        object class, which is the exact same as ==
         */

        System.out.println(sb2 == sb3);
        System.out.println(sb2.equals(sb3));

        sb2.append(" How's it going?");
        System.out.println(sb2);

    }
}
