public static void main(String[] arg) {
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        s2.concat("West");
        System.out.println(s2);

        s2 = s2.concat("West");
        s3 = s3.intern();
        System.out.println(s2);
        System.out.println(s1.equals(s3));

        String s5 = "NorthWest";
        System.out.println(s2 == s5);
        System.out.println(s2.equals(s5));


        /*String interning is the act of moving a string object -which exists outside of the string pool and "interning " or moving it into the string pool.

         */
/* Stringbuilder
-mutable
-not thread-safe

StringBuffer
-mutable
-thread-safe
/*

 */


//StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello");
        StringBuilder sb3 = new StringBuilder("Hello");
        System.out.println(sb2 == sb3);


        sb2.append("How's it going");
        System.out.println(sb2);
        }
        }