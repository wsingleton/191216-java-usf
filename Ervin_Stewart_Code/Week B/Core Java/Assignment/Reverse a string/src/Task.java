import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {


        Stack<Character> stack = new Stack<Character>();
        char[] originalString = reverseMe.toCharArray();
        for(int i =0; i <reverseMe.length(); i++){
            stack.push(originalString[i]);

        }

        int J =0;
        while(!stack.isEmpty()){
            originalString[J++] =stack.pop();
        }


        return String.copyValueOf(originalString);
    }

}