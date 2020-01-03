import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        char[] stringChar = reverseMe.toCharArray();

        Stack<Character> characterStack = new Stack<>();

        for(char c: stringChar) characterStack.push(c);

        int k = 0;
        while (!characterStack.isEmpty()){
            stringChar[k++] = characterStack.pop();
        }

        return String.copyValueOf(stringChar);

    }

}