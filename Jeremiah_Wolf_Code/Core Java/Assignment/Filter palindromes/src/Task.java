import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {
        if (wordArray == null || wordArray.length == 0) {
            return new String[0];
        }
        Object[] _palindromes = Arrays.stream(wordArray)
                .filter(word -> word != null && isPalindrome(word))
                .toArray();
        return Arrays.copyOf(_palindromes, _palindromes.length, String[].class);
    }
    public boolean isPalindrome(String word) {
        String sanitizedWord = word.toLowerCase().replaceAll("\\W", "");
        StringBuilder reversedWord = new StringBuilder(sanitizedWord).reverse();
        return sanitizedWord.equals(reversedWord.toString());
    }
}