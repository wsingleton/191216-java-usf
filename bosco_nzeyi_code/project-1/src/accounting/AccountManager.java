package accounting;

import users.UserLogIn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {

    public String data; //user data
    public String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

    // methods from other classes to use later in this class
    RecordKeeper recorder = new RecordKeeper(); // calling recordKeeper object
    UserLogIn user = new UserLogIn(); // calling the UserLogin object to use it here
    public int balance;

    // method to get user's current balance
    public void getBalance (int userId){
        ArrayList<String> userTransactions = recorder.transactions(new Integer(userId).toString());
        int lastIndex = userTransactions.size() - 1;
        String lastLine = userTransactions.get(lastIndex).trim(); // to get the last line as it is the one with updated balance

        // get the current balance
        String [] linePieces = lastLine.split(" ");
        int currentBalance = new Integer(linePieces[linePieces.length - 1]);
        System.out.println("Your current balance is $" + currentBalance);
    }


    /**
     * method to record deposit and withdraw activities
     * @param userId
     * @param transactionType
     */
    public void transaction(int userId, String transactionType){
        // get record from the logged in user
        Integer loggedId = new Integer(userId);
//        recorder.transactions(loggedId.toString());
//        ArrayList<String> userHistory = recorder.data;
        ArrayList<String> userHistory = recorder.transactions(loggedId.toString());
        if (userHistory.isEmpty()){
            // if the there is no user history, no need to calculate balance so the deposit amount can be added to it.
            // We proceed straight to recording the transaction.

            Scanner read = new Scanner(System.in);
            System.out.println("Enter amount");
            String amountInput = read.nextLine();

//            int amount = 0;

            if(amountInput != null){
                try{
                   Integer amount = Integer.parseInt(amountInput);
                    if(amount < 0){
                        System.out.println("Can't save negative amount. Try again later!");
                    } else {


                        // if transaction type is deposit, the balance will be to add the amount, if withdrawal we will do the opposite.
                        switch (transactionType) {
                            case "deposit":
                                data = userId + " deposit " + date + " " + amount + " " + amount;

                                // now we write the transaction to the file.
                                recorder.record(data);
                                break;
                            // No withdraw allowed for the first transaction.
                            case "withdraw":
                                System.out.println("Insufficient balance. First make a deposit before you withdraw!");
                                break;
                            default:
                                System.out.println("No operation selected");
                        }
                    }

                } catch (Exception e){
//                    e.printStackTrace();
                    System.err.println("Invalid amount!");
                }
            } else {
                System.out.println("invalid input!");
            }

        } else {
            /*
            if we have have data associated to the user, we will calculate the balance first so we can update it in the record.
             */
            Scanner read = new Scanner(System.in);
            System.out.println("Enter amount");
            String amountInput = read.nextLine();

            if(amountInput != null){
                try{
                   Integer amount = Integer.parseInt(amountInput);
                   if(amount < 0){
                       System.out.println("Can't save negative amount. Try again later!");
                   } else {

                       int lastIndex = userHistory.size() - 1;
                       String lastLine = userHistory.get(lastIndex).trim(); // to get the last line as it is the one with updated balance
                       // get the current balance
                       String[] linePieces = lastLine.split(" ");
                       int currentBalance = new Integer(linePieces[linePieces.length - 1]);

                       // set the balance to currentBalance
                       balance = currentBalance;

                       // if transaction type is deposit, the balance will be to add the amount, if withdrawal we will do the opposite.
                       switch (transactionType) {
                           case "deposit":
                               int updatedBalance = currentBalance + amount;

                               // set balance to the updated balance
                               balance = updatedBalance;

                               data = userId + " " + transactionType + " " + date + " " + amount + " " + updatedBalance; // data to write to the file.
                               // now we write the transaction to the file.
                               recorder.record(data);
                               break;

                           // To update the balance, we will deduct the amount withdrawn.
                           case "withdraw":

                               // prevent overdraft
                               if (amount > currentBalance && !(amount < 0)) {
                                   System.out.println("Insufficient balance. Enter a lesser amount that matches with your balance!" + "\n" +
                                           "Enter 1 to enter a valid amount, or press any key to exit.");
                                   Integer cont = new Integer(read.nextLine());
                                   if (cont.equals(1)) {
                                       System.out.println("Now enter a new amount to withdraw");
                                       String money = read.nextLine();
                                       try{
                                           amount = new Integer(money);
                                       } catch(Exception e){
                                           System.err.println("Invalid amount");
                                           System.out.println("Try again next time");
                                           break;
                                       }
//                                       amount = new Integer(read.nextLine());
                                       if (amount < currentBalance && !(amount < 0)) {
                                           updatedBalance = currentBalance - amount;

                                           // set balance to the updated balance
                                           balance = updatedBalance;

                                           data = userId + " " + transactionType + " " + date + " " + amount + " " + updatedBalance;
                                           // now we write the transaction to the file.
                                           recorder.record(data);
                                       } else {
                                           System.out.println("Invalid input. Thank you for banking with us! bye!");
                                       }
                                   } else {
                                       System.out.println("Thank you for banking with us! bye!");
                                   }
                               } else {
                                   updatedBalance = currentBalance - amount;

                                   // set balance to the updated balance
                                   balance = updatedBalance;

                                   data = userId + " " + transactionType + " " + date + " " + amount + " " + updatedBalance; // data to write to the file.
                                   // now we write the transaction to the file.
                                   recorder.record(data);
                               }
                               break;
                           default:
                               System.out.println("No operation selected");
                       }
                   }

                } catch (Exception e){
//                    e.printStackTrace();
                    System.err.println("Invalid amount!");
                }
            } else{
                System.out.println("invalid input!");
            }

        }
    }
}
