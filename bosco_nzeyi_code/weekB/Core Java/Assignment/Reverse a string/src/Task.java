import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        String toReverse = reverseMe;
        String reversedString = "";
        for(int i = toReverse.length() - 1; i >= 0; i--){
            reversedString = reversedString + toReverse.charAt(i);
        }
        return reversedString;

    }

}