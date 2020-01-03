import java.util.*;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        if(wordArray == null || wordArray.length == 0){
            return new String[0];
        }
        String[] answer = new String[0];
        for(String s: wordArray){
            if(isPalindrome(s)){
                answer = Arrays.copyOf(answer, answer.length+1);
                answer[answer.length-1] = s;
            }
        }
        return answer;
    }

    public boolean isPalindrome(String word) {

        if(word == null || word == ""){
            return false;
        }else if(word.length() == 1){
            return false;
        }
        word = word.toLowerCase();
        char[] charArray = word.toCharArray();
        LinkedList<Character> charList = new LinkedList<>();
        for(char c: charArray){
            if(c > 96 && c < 123 || c > 47 && c < 58){
                charList.add(c);
            }
        }
        while(charList.size() > 1){
            char first = charList.removeFirst();
            char last =charList.removeLast();
            if(first != last){
                return false;
            }
        }
        return true;
    }

}