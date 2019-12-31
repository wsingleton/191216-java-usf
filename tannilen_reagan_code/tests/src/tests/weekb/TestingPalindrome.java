package tests.weekb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class TestingPalindrome {
    public static void main(String[] args) {
        String[] testStrings=new String[3];
        testStrings[0]="Do geese see god?";
        testStrings[1]="palindrome";
        testStrings[2]="ewe";
        String[] output=filterPalindromes(testStrings);
        for(String o : output) {
            System.out.println(o);
        }
    }

        public static String[] filterPalindromes(String[] wordArray) {

            if (wordArray==null) {
                return new String[0];
            }
            if (wordArray.length==0) {
                return new String[0];
            }
            ArrayList<String> filteredWords=new ArrayList<>();
            for(String testCase : wordArray) {
                System.out.println("Testing string " + testCase);
                if (testCase!=null && testCase!="") {
                    boolean valid;
                    String holder=testCase;
                    testCase=testCase.trim();
                    testCase=testCase.replaceAll(" ", "");
                    testCase=testCase.toLowerCase();
                    testCase=testCase.replace(".", "");
                    testCase=testCase.replace(",", "");
                    testCase=testCase.replace("'", "");
                    testCase=testCase.replace("\"","");
                    testCase=testCase.replace("(","");
                    testCase=testCase.replace(")","");
                    testCase=testCase.replace("!","");
                    testCase=testCase.replace("$", "");
                    testCase=testCase.replace("?", "");
                    testCase=testCase.replace("@","");
                    testCase=testCase.replace("&","");
                    testCase=testCase.replace(";", "");
                    System.out.println("Modified string: " + testCase);
                    valid=isPalindrome(testCase);
                    System.out.println("Test case evaluates to " + valid);
                    if (valid==false){
                        filteredWords.add(new String(holder));
                        System.out.println("Adding " + holder + " to filtered words.");
                    }
                }
            }
            String[] validResults=new String[filteredWords.size()];
            for (int i = 0; i<filteredWords.size(); i++) {
                validResults[i]=filteredWords.get(i);
            }
            return validResults;
        }

        public static boolean isPalindrome(String word) {
            StringBuilder testCase=new StringBuilder(word.length());
            testCase.append(word);
            String reverse=testCase.reverse().toString();
            if (word.equals(reverse)) {
                return true;
            }
            else {
                return false;
            }
        }
    }
