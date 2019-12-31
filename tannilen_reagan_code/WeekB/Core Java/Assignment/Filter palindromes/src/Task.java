import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if (wordArray == null) {
            return new String[0];
        }
        if (wordArray.length == 0) {
            return new String[0];
        }
        ArrayList<String> filteredWords = new ArrayList<>();
        for (String testCase : wordArray) {
            if (testCase != null) {
                if (testCase == "") {
                    filteredWords.add("");
                } else {
                    boolean valid;
                    String holder = testCase;
                    testCase = testCase.trim();
                    testCase = testCase.replaceAll(" ", "");
                    testCase = testCase.toLowerCase();
                    testCase = testCase.replace(".", "");
                    testCase = testCase.replace(",", "");
                    testCase = testCase.replace("'", "");
                    testCase = testCase.replace("\"", "");
                    testCase = testCase.replace("(", "");
                    testCase = testCase.replace(")", "");
                    testCase = testCase.replace("!", "");
                    testCase = testCase.replace("$", "");
                    testCase = testCase.replace("?", "");
                    testCase = testCase.replace("@", "");
                    testCase = testCase.replace("&", "");
                    testCase = testCase.replace(";", "");
                    valid = isPalindrome(testCase);
                    if (valid == true) {
                        filteredWords.add(holder);
                    }
                }
            }
        }
            String[] validResults = new String[filteredWords.size()];
            for (int i = 0; i < filteredWords.size(); i++) {
                validResults[i] = filteredWords.get(i);
            }
            return validResults;
        }

    public boolean isPalindrome(String word) {
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