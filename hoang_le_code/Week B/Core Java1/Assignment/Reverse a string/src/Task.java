import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {
        String a = "";

        for (int i = reverseMe.length() -1; i >= 0 ; i -- ){
            a = a + reverseMe.charAt(i);
        }
        return a;

    }

}