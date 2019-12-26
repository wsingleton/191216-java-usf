package mockBank;

public class BankMain {

    public static void main(String[] args) {

        Account person1 = new Account(); //Creating account object
        person1.deposit(500);

        //Create person2

        Account person2 = new Account(); //Creating account object
        person2.deposit(100);

        System.out.print("Person1 has a balance of ");
        System.out.println(person1.getBalance());
        System.out.print("Person2 has a balance of ");
        System.out.println(person2.getBalance());
    }
}
