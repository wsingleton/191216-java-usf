package mockBank;

public class Account {

    private double balance;
    //setting balance to 0
     public Account(){
         balance =0.0;
     }
     //Deposit
    public void deposit(double amount) {
         balance = balance + amount;
    }

    //withdraw
    public void withdraw(double amount) {
         balance = balance - amount;
    }
    //Get balance

    public double getBalance() {
        return balance;
    }
}
