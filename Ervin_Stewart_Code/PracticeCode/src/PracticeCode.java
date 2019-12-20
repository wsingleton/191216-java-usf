import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.*;
public class PracticeCode {





public class UserID{
    public String m;
    private int year;
    private boolean isLeapYear;
    private boolean isfemale;
    private boolean ismale;
    private int age;
    private int day;
    private int month;
    private String gender;
    private String Birthday;
    private String firstname;
    private String Password;
    private String UserName;

   public void UserID(String Birthday, String UserName, int age) {
       this.Birthday = Birthday;
       this.age = age;
   }



  // public String generateUsername(String firstname, String lastname){

  // }

}

    public static void main(String... args){
//    boolean continuation= false;
//    Scanner input = new Scanner(System.in);
//        do {
//            System.out.print("Enter an email ");
// int i;
//            String email = input.next();
//            System.out.println(email);
//            if(email.equals(" ") || email.equals(null) ){
//                System.out.println("valid email");
//                //continuation = true;
//            }else continuation=true;//System.out.println("Frist name not valid please enter a first name");
//
//        }while(!continuation);
//        do{
//            System.out.println("enter your first name");
//            String firstname = input.next();
//
//
//        }while(!continuation);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);
       // boolean exc =false;
        boolean negInputStatus = false;
        //do {
           // int deposit =0;
           // negInputStatus = true;
        public static void setDepositAmount() {
            System.out.println("please enter your Deposit Amount");
            if (isInt(input) == true) {
                System.out.println("invalid input, try again");
            }
            ;
            System.out.println("thank you for your valid input");
        }
            //    else
              //      exc= false;

          //  }while( !negInputStatus);


    }

    public static boolean isInt(Scanner input) {
        //int deposit;
        boolean invalid = false;
        try {
           // deposit = input.nextInt();
        } catch (InputMismatchException e) {

              System.out.println("invalid input");
              invalid = true;

            }
        return invalid;
    }
    public static void setDepositAmount() {
        System.out.println("please enter your Deposit Amount");
        if (isInt(input) == true) {
            System.out.println("invalid input, try again");
        }
        ;
        System.out.println("thank you for your valid input");
    }

}//} //e.InputMismatchException("invalid input");
//negInputStatus = false;
//  String m = e.toString();
//  if(m.equals("InputMismatchException") ){//      exc= true;