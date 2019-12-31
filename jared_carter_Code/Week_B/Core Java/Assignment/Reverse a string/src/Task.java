import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        //String reverseMe = "reverse";

        if (reverseMe == null || reverseMe.equals("")) {
            return "";
        }

        char[] reversingChar = reverseMe.toCharArray();
        Stack<Character> letter = new Stack<>();
        for (char a : reversingChar) letter.push(a);

        int i = 0;
        while (!letter.isEmpty()) {
            reversingChar[i++] = letter.pop();
        }
    return String.copyValueOf(reversingChar);
    }
/*

    String str = " "

    int length = str.length();
    String reverse = "";

    for(int i =length; i >=0; i--){
        reverse = reverse + str.charAt(i);
    }

     */



}