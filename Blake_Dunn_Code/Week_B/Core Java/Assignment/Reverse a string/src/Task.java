import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        Stack<Character> stack = new Stack<Character>();

        char[] ch = reverseMe.toCharArray();
        for (int i = 0; i < reverseMe.length(); i++) {
            stack.push(ch[i]);
        }

        int k = 0;

        while(!stack.isEmpty()) {
            ch[k++] = stack.pop();
        }

        return String.copyValueOf(ch);

    }

}