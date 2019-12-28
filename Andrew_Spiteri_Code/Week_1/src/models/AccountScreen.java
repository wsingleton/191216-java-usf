package models;

import java.text.DecimalFormat;
import java.util.Scanner;

import static models.Account.getAccountAmount;

public class AccountScreen {
    protected static void printToScreen(Account account){
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Would you like to view your account balance (0), deposit (1), withdraw (2), or exit (3)");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.next()){
            case "0":
                System.out.println("Your account balance is: " + df.format(getAccountAmount(account.getId())));
                break;
            case "1":
                System.out.println("How much would you like to deposit?");
                try{
                    Double deposit = scanner.nextDouble();
                    account.setAccountAmount(account.getAccAmount().doubleValue() + deposit);
                }catch (Exception e){
                    printToScreen(account);
                }
                break;
            case "2":
                System.out.println("How much would you like to withdraw?");
                try{
                    Double withdrawal = scanner.nextDouble();
                    if(withdrawal > 0 && (account.getAccAmount() - withdrawal) >= 0){
                        account.setAccountAmount(account.getAccAmount() - withdrawal);
                    }else{
                        System.out.println("Error! Incorrect input!");
                    }
                }catch(Exception e){
                    printToScreen(account);
                }
                break;
            case "3":
                System.exit(0);
                break;
        }

        printToScreen(account);
    }
}
