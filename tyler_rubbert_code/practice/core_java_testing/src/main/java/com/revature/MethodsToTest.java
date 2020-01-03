package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodsToTest {

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

    public String[] filterPalindromes(String[] wordArray) {

        if (wordArray == null || wordArray.length == 0) {
            return new String[0];
        }

        String[] palindromes = new String[0];

        int counter = 0;
        for (int i = 0; i < wordArray.length; i++) {
         //   System.out.println(wordArray[i]);
            if (isPalindrome(wordArray[i]) == true) {

                palindromes = Arrays.copyOf(palindromes, ++counter);
                palindromes[counter -1] = wordArray[i];
            }

        }

        for (String s : palindromes) {
            System.out.println(s);
        }

        return palindromes;
    }

    public String createAcronymFromPhrase(String phrase) {
        if (phrase == null || phrase.trim().equals("")) {
            return "";
        }

//        String result = "";
//
//        phrase.replaceAll("-", " ");
//        phrase.replaceAll("[0-9]","");
//        List<String> wordList = new ArrayList<>(Arrays.asList(phrase.split(" ")));
//
//
//        for (String s : wordList) {
//            result = result.concat(String.valueOf(s.charAt(0)));
//        }
//
//        return result.toUpperCase();
//
//
//    }

    public boolean isPalindrome(String word) {

        if (word == null || word.equals("")){
            return false;
        }

        StringBuffer clone = new StringBuffer(word.replaceAll("[^a-zA-Z0-9]+","").toLowerCase());
        clone = clone.reverse();
        if (clone.toString().equals(word.replaceAll("[^a-zA-Z0-9^]+","").toLowerCase())) return true;
        else return false;





    }

//    public int[] determineMinAndMax(int[] copy) {
//
//        if (copy == null || copy.length == 0) {
//            return new int[0];
//        }
//
//        for (int i = copy.length-1;i >= 0;i-- ){
//            for (int j = copy.length-1; j >= 0; j--) {
//                if (copy[i] > copy[j]) {
//                    int temp = copy[j];
//                    copy[j] = copy[i];
//                    copy[i] = temp;
//                }
//            }
//
//        }
//        return copy;
//    }
//
//    public String[] fizzBuzz(int[] values) {
//
//        String[] solution = new String[values.length];
//
//        for (int i = 0; i < solution.length; i++) {
//            if ((i + 1) % 3 == 0) {
//                if ((i + 1) % 5 == 0) {
//                    solution[i] = "fizzbuzz";
//                } else {
//                    solution[i] = "fizz";
//                }
//            }else if((i + 1) % 5 == 0){
//                solution[i] = "buzz";
//            } else {
//                solution[i] = String.valueOf(values[i]);
//            }
//        }
//        return solution;
//
//    }


}

