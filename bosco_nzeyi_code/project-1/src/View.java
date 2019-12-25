/*
This class act as the main user interface for clients to interact with the program.

Objectives:
- to sign up users;
- to log in;
- view balance;
- deposit;
- withdraw;
- and to see their activity logs.
 */

import java.util.Scanner;

public class View {

    AccountManager record = new AccountManager();

    public void findOperator (String input){
        input.toLowerCase().trim();

        String [] fullInput = input.split(" ");

//        System.out.println(fullInput.length);
//        for (String word: fullInput
//             ) {
//            System.out.println(word);
//        }
        String operator = fullInput[0].toLowerCase();
        String number = fullInput[1];
        System.out.println(operator);

        switch (operator){
            case "deposit":
                int amount = Integer.parseInt(number);
                record.deposit(amount);
                break;

            case "withdraw":
                amount = Integer.parseInt(number);
                record.withdraw(amount);
                break;

            case "balance":
                record.getBalance();
                break;

            case "activities":
                record.activityLog();
                break;

            default:
                System.out.println(" Please enter the appropriate operator");

        }


    }

    public static void main (String [] args){
//        AccountManager manager = new AccountManager();
        System.out.println("What do you want to do?");
        Scanner input = new Scanner(System.in);
        String activity = input.nextLine();

        View task = new View();
        task.findOperator(activity);


    }
}
