import java.lang.reflect.Array;
import java.util.*;



public class HelloWorld {


    Scanner keyboard = new Scanner(System.in);

    ArrayList<Character> charList = new ArrayList<Character>();

    System.out.println("please enter 3 words");
    String phrase = keyboard.nextLine();
    String[] acro  = phrase.split(" ");

    for(int i=0; i < acro.length; i++){
        System.out.print(acro[i].charAt(0));
        charList.add(acro[i].charAt(0));
    }

    charList.toString();
}




    public static void main(String[] args) {


}



//        public static String createAcronymFromPhrase(String phrase) {
//
//
//            String s  = phrase;
//            char c[] = s.toCharArray();
//            System.out.println("the first character of the phrase is " + s.charAt(0));
//
//
//            return phrase;
//
//
//        }