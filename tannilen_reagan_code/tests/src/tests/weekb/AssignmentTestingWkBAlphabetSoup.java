package tests.weekb;

import java.util.ArrayList;
import java.util.List;

public class AssignmentTestingWkBAlphabetSoup {
    public static void main(String[] args) {
        String phrase = "3 tier cake";
        if (phrase == null || phrase == "") {
            return "";
        } else {
            String restring = phrase.replace(' ', '-');
            ArrayList<String> wordCapture=new ArrayList<>();
            String[] words=restring.split("-");
            for (int i=0;i<words.length;i++) {
                wordCapture.add(words[i]);
            }
            int wordCount = wordCapture.size();
            String solution = "";
            for (int i=0;i<wordCount;i++){
                if (!Character.isAlphabetic(wordCapture.get(i).charAt(0))) {
                    wordCapture.remove(i);
                    if (i<0) {i--;}
                    wordCount--;
                }
            }
            for (int i = 0; i < wordCount; i++) {
                solution = solution + (wordCapture.get(i).charAt(0));
            }
            String acronym = solution.toUpperCase();
            return acronym;
        }
    }
}