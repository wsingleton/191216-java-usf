package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String phrase = "    The   quick brown fox  jumped over the lazy  dog    ".trim();
        String acronym = "";

        String[] phraseHolder;
        phrase = phrase.replaceAll("[0-9]", "").replaceAll("[^a-zA-Z]+", " ");
        System.out.println(phrase);
        phraseHolder = phrase.split(" ");
        for (String phrase1 : phraseHolder
        ) {
                acronym += phrase1.charAt(0);
        }
        System.out.println(acronym.toUpperCase());
//        String mainString = "HelloWorld";
//        int start = 2;
//        int end = 5;
//        if(mainString == "" || mainString == null){
//            System.out.println("");
//        }
//        String[] substringArr = mainString.split("");
//        String arr = "";
//        for (int i = start; i < end; i++){
//            arr += substringArr[i];
//        }
//        System.out.println(arr);
//        System.out.println(mainString.substring(2,5));
    }


}
