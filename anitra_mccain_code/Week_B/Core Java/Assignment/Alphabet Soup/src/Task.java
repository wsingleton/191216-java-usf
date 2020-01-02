import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Task {

    public static void createAcronymFromPhrase(String phrase) {

//How do you get the first letter of every word?

        String inputString = phrase;
//        System.out.println(inputString);
        Stack<Character> STACK = new Stack<Character>();
        String[] splitThisString = inputString.split(" ");
        String acronym = "";


        for (String a: splitThisString) {
//            System.out.println(a);
//            System.out.println(a.charAt(0));
            STACK.push(a.charAt(0));
        }

        for (Character character : STACK) {
            acronym = acronym + character.toString();

        }

        System.out.println(acronym);




//        System.out.println(acronym);

//        System.out.println(Arrays.toString(splitThisString));




    }

    public static void main(String[] args) {
        Task task1 = new Task();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a phrase ");
        String typedString = scanner.nextLine();

        task1.createAcronymFromPhrase(typedString);

    }

}