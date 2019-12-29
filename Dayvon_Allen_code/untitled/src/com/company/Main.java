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

        String[] wordArray = {"test", "house", "racecar"};
        int count = 0;
        StringBuilder[] reverseString = {new StringBuilder("name")};
        for (String s: wordArray
             ) {
            reverseString[count].append(s).reverse();
            System.out.println(reverseString[count].toString());
            count++;
        }

    }


}
