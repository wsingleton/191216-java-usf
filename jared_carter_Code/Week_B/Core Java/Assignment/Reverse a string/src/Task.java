import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        //String reverseMe = "reverse";

        if (reverseMe == null || reverseMe.equals("")) {
            return "";
        }

        char[] reversingChar = reverseMe.toCharArray();
        Stack<Character> stackOfCharacter = new Stack<>();
        for (char a : reversingChar) stackOfCharacter.push(a);

        int i = 0;
        while (!stackOfCharacter.isEmpty()) {
            reversingChar[i++] = stackOfCharacter.pop();
        }
    return String.copyValueOf(reversingChar);
    }



}