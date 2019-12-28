package mockBank;

public class Account {
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000000;

    Account(){
        accountNumber = numberOfAccounts++;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
