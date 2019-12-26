package com.company;

public class Main {

    public static void main(String[] args) {
//        String acronym = "";
//        String phrase = "Objectoriented Programming";
//        for (int i = 0; i < phrase.length(); i++){
//            char testChar = phrase.charAt(i);
//            if(testChar == Character.toUpperCase(phrase.charAt(i)) && Character.isAlphabetic(testChar)){
//                acronym += Character.toString(testChar);
//            }
//        }
//        acronym = acronym.replaceAll("\\s", "");
//        System.out.println(acronym);
        String word = "name";
        String answer = "";
        String[] test = word.split("");
        int counter = test.length - 1;
        for (String i :  test){
            System.out.println(test[counter]);
            answer += test[counter];
            counter--;
        }

    }
}
