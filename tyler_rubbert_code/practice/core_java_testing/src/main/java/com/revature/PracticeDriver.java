package com.revature;

public class PracticeDriver {

    public static void main(String[] args) {
       // int[] testArray = {1, 11, -3, 1, 5, 7, 2, 0, 3, 13};
        //int[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        String[] testArray = {
                "alice",
                "racecar",
                "Do geese see God?",
                null,
                "not a palindrome",
                null,
                "kayak",
                "null"
        };

        MethodsToTest test = new MethodsToTest();
//        int[] temp = test.determineMinAndMax(testArray);
//        for(int s : temp){
//            System.out.println(s);
//        }

        test.filterPalindromes(testArray);



    }
}
