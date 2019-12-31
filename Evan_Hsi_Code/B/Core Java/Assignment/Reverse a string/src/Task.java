import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {
        if(reverseMe == null) return "";
        if(reverseMe.length() < 2) return reverseMe;
        char[] charArray = new char[reverseMe.length()];
        for(int i = reverseMe.length() - 1; i >= 0; i--) {
            charArray[reverseMe.length()-1-i] = reverseMe.charAt(i);
        }
        String reversed = new String(charArray);
        return reversed;
    }

}