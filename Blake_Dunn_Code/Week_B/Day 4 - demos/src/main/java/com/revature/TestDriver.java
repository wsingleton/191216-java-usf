package com.revature;

import com.revature.util.Test;

public class TestDriver {

    public static void main(String[] args) {

        String[] testArray = {
                "alice",
                "racecar",
                "Do geese see God?",
                "Madam, I'm Adam.",
                "not a palindrome",
                "java",
                "kayak",
                "noon"
        };

        Test.filterPalindromes(testArray);


    }
}
