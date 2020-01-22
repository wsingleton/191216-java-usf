package com.revature.services;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.repos.AccountRepository;
import static com.revature.BankDriver.router;

public class AccountService {

    private double depositAmount;
    private double balance;
    AccountRepository acct = new AccountRepository();

    public AccountService() {
    }

    public void deposit(String depositAmount) {
            //checks if the depositAmount is valid
            if(depositAmount.matches("\\d+(\\.\\d{1,2})?")){
                this.depositAmount = Double.parseDouble(depositAmount) + acct.findAccountBalanceById();
                acct.increaseAccountBalance(this.depositAmount);
                router.navigate("/balance");
            }
            else {
                throw new InvalidRequestException();
            }
    }

    public void withdraw(String withdrawAmount) {
            //checks if the withdrawAmount is valid
            if (withdrawAmount.matches("\\d+(\\.\\d{1,2})?")) {
                    balance = acct.findAccountBalanceById() - Double.parseDouble(withdrawAmount);
                    if (balance  < 0.0) {
                        throw new ResourcePersistentException();
                    } else {
                        acct.decreaseAccountBalance(balance);
                        router.navigate("/balance");
                    }
                }
            else {
                throw new InvalidRequestException();
            }
    }
}
