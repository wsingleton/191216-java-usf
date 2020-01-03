import java.util.Arrays;
import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        if(reverseMe == null || reverseMe.equals("")){
            return "";
        }
        Stack<Character> stack = new Stack<>();
        char[] str = reverseMe.toCharArray();
        String rev = "";

        for(int i = 0; i<str.length; i++){
            stack.push(str[i]);
        }

        for(int j = 0; j < str.length; j++){
            char temp = stack.pop();
            rev += temp;
        }

        return rev;

    }

}