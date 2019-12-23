import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        String s = "";
        for (int i = reverseMe.length()-1; i >= 0;i-- ){
            s = s + reverseMe.charAt(i);
        }
        return s;
    }

}