package MockBank;

import java.util.Scanner;

public class BankInput {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter name, age, and salary: ");

        //String input from user
        String name = myObj.nextLine();

        //the num input
        int age = myObj.nextInt();
        double salary = myObj.nextDouble();

        //output of the input by the user
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("salary: " + salary);
    }


}
