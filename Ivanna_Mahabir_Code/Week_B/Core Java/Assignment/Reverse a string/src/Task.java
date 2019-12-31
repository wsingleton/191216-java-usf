import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        if(reverseMe == null || reverseMe.equals("")){
            return "";
        }
        Stack<Character> stack = new Stack<>();
        char[] str = reverseMe.toCharArray();

        for(int i = 0; i<reverseMe.length(); i++){
            stack.push(str[i]);
        }
        int j = 0;
        while(!stack.isEmpty()){
            str[j++] = stack.pop();
        }

        return String.copyValueOf(str);

    }

}