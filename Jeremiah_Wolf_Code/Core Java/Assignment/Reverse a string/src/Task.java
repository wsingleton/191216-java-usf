import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {
        if (reverseMe == null || reverseMe.equals("")) {
            return "";
        }
        char[] stringChars = reverseMe.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        for(char c : stringChars) characterStack.push(c);
        int k = 0;
        while(!characterStack.isEmpty()) {
            stringChars[k++] = characterStack.pop();
        }
        return String.copyValueOf(stringChars);
    }

}