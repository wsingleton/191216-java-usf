import java.util.Scanner;

public class Task {

    public static void main(String[] args) {

        Task reversedString1 = new Task();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String noReverse = scanner.nextLine();
        System.out.println("Reverse of a String is : " + reversedString1.reverse(noReverse));
    }

    public String reverse(String reverseMe) {
        String input = reverseMe;
        String reversedOutput = "";
        for(int i = reverseMe.length(); i > 0; --i) {
            reversedOutput = reversedOutput + (reverseMe.charAt(i-1));
        }
        return reversedOutput;
    }
}

