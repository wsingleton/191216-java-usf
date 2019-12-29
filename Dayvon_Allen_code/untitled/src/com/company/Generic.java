package com.company;

public class Generic{

    public static boolean isPalindrome(String word) {
        StringBuffer s = new StringBuffer(word.replaceAll("[^a-zA-Z]+", "").toLowerCase());
        System.out.println(s.toString());
        s = s.reverse();
        if(s.toString().equals(word.replaceAll("[^a-zA-Z]+", "").toLowerCase())){
            return true;
        }
        return false;
    }
}
