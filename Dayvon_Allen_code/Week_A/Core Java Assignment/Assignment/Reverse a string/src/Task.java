import java.util.Stack;

public class Task {

    public String reverse(String reverseMe) {

        // Handle the base cases; string is null or empty - return empty string
        if (reverseMe == null || reverseMe.equals("")) {
            return "";
        }

        // Instantiate a char array that will hold the chars of the string in reverse order
        char[] stringChars = reverseMe.toCharArray();

        // Instantiate a stack to hold characters of the string to be reversed
        Stack<Character> characterStack = new Stack<>();

        // Iterate across stringChars obtained from the string and push each char into the stack
        for(char c : stringChars) characterStack.push(c);

        // Reverse the order of the chars in stringChars using characterStack
        int k = 0;
        while(!characterStack.isEmpty()) {
            stringChars[k++] = characterStack.pop();
        }

        // Return the reversed string
        return String.copyValueOf(stringChars);

    }

}