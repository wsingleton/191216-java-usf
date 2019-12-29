package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        String phrase = "    The   quick brown fox  jumped over the lazy  dog    ".trim();
//        String acronym = "";
//
//        String[] phraseHolder;
//        phrase = phrase.replaceAll("[0-9]", "").replaceAll("[^a-zA-Z]+", " ");
//        System.out.println(phrase);
//        phraseHolder = phrase.split(" ");
//        for (String phrase1 : phraseHolder
//        ) {
//                acronym += phrase1.charAt(0);
//        }
//        System.out.println(acronym.toUpperCase());
//        String[] temp = elements;
//
//        elements[elements.length - 1] = null;
//        elements = new String[temp.length -1];
//
//        for (int i = 0; i < temp.length -1; i++){
//            elements[i] = temp[i];
//        }
//
//        return temp[temp.length - 1];

       String[] wordArray = {    "alice",
               "not a palindrome",
               "java",
               "blah",
               "test",
               "nope"};
        if(wordArray == null || wordArray.length == 0){
            System.out.println(new String[0]);
        }
        String palinString = "";
        for (String s: wordArray
        ) {
            if (s != null && !s.equals("")){
                if(Generic.isPalindrome(s)){
                    palinString += s.replaceAll("[^a-zA-Z]+", "") + " ";
                }
            }
        }
        System.out.println(palinString);
        System.out.println(palinString.length());
        System.out.println(palinString.split(" ").length);
        System.out.println(palinString.split(" ").toString());
        for (String s: palinString.split(" ")
             ) {
            System.out.println(s);

        }

    }


}
