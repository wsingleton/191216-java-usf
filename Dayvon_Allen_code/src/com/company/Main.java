package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String acronym = "";
        String phrase = "C-Moss";
        for (int i = 0; i < phrase.length(); i++){
            char testChar = phrase.charAt(i);
            if(testChar == Character.toUpperCase(phrase.charAt(i)) && Character.isAlphabetic(testChar)){
                acronym += Character.toString(testChar);
            }
        }
        acronym = acronym.replaceAll("\\s", "");
        System.out.println(acronym);
    }
}
