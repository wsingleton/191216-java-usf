package com.revature.util;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Test {

    public static String[] filterPalindromes(String[] wordArray) {

        if (wordArray == null || wordArray.length == 0) {
            return new String[0];
        }

        String[] copy = new String[0];

        for (int i = 0; i < wordArray.length ; i++){
            if (isPalindrome(wordArray[i])){
                copy = Arrays.copyOf(copy, copy.length + 1);
                copy[copy.length - 1] = wordArray[i];
            }
        }
        for (int i = 0; i < copy.length; i++){
            System.out.println(copy[i]);
        }
        return copy;


    }

    public static boolean isPalindrome(String word) {

        if (word == null) {
            return false;
        }

        word = word.toLowerCase().replaceAll("\\W", "")
                .replaceAll("\\s","");
        int i = 0;
        int j = word.length() - 1;

        while (i < j) {

            if (word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
