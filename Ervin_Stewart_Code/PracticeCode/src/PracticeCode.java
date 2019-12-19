import java.util.*;
public class PracticeCode {





public class UserID{
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
    boolean continuation= false;
    Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter an email ");

            String email = input.next();
            System.out.println(email);
            if(email.contains("@")){
                System.out.println("valid email");
                continuation = true;
            }else System.out.println("email not valid");

        }while(!continuation);
        do{
            System.out.println("enter your first name");
            String firstname = input.next();


        }while(!continuation);



    }}