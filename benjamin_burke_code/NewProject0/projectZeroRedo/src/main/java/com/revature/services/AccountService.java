package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Accounts;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.io.IOException;


import static com.revature.AppDriver.app;

public class AccountService {

    private AccountRepository accountRepo;

    public AccountService(){

    }

    public AccountService(AccountRepository accRepo) {this.accountRepo = accRepo;}

//hmmmm need to add account
    public Accounts getAccByAccUsername(){
//        if(username == null || username.trim().equals("")) {
//            throw new InvalidRequestException();
//        }
////        if(accountRepo.findAccountByUsername(username).isPresent()) {
////            accountRepo.findAccountByUsername(username).orElseThrow(AuthenticationException::new);
////        }
////        else{
////            Accounts newAcct = new Accounts(username);
////            accountRepo.save(newAcct);
////            currentAcc = newAcct;
////        }
        return accountRepo.getAccountByUsername(app().getCurrentSession().getSessionUser().getUsername()).get();


    }


//    public Double validateDeposit(Double init, Double deposit) throws IOException {
//        if(deposit >= 0 ){
//            deposit += init;
//            app().setBalance(deposit);
//            accountRepo.updateAccount(currentAcc.getAccountNumber(), deposit);
//        }
//        else{
//            System.out.println("Invalid Deposit Amount Entered\n\n");
//            app().getRouter().navigate("/dashboard");
//        }
//        return deposit;
//    }

    public double Deposit(double deposit){
        if (deposit<0) throw new InvalidRequestException();

        User currentUser = app().getCurrentSession().getSessionUser();
        Accounts currentAccount = accountRepo.getAccountByUsername(app().getCurrentSession().getSessionUser().getUsername()).get();

        currentAccount.setBalance(currentAccount.getBalance() + deposit);

        //no idea
        accountRepo.update(currentAccount);

        return currentAccount.getBalance();


    }

    public double Withdraw(double withdraw){
        if (withdraw < 0) throw new InvalidRequestException();
        User currentUser = app().getCurrentSession().getSessionUser();
        Accounts currentAccount = accountRepo.getAccountByUsername(app().getCurrentSession().getSessionUser().getUsername()).get();

        if (currentAccount.getBalance() - withdraw < 0) throw new InvalidRequestException();
        currentAccount.setBalance(currentAccount.getBalance() - withdraw);

        accountRepo.update(currentAccount);

        return currentAccount.getBalance();
    }




    public void register(Accounts newAcc){
        System.out.println("dfajlkfjsal");
        if (!isValid(newAcc)) throw new InvalidRequestException();
        System.out.println("dfajlkfjsal");

        accountRepo.save(newAcc);
    }

//    public Double validateWithdraw(Double init, Double withdraw) throws IOException {
//        if(withdraw >= 0 ){
//            if(withdraw <= init){
//                withdraw = init - withdraw;
//                currentAcc.setBalance(withdraw);
//                accountRepo.updateAccount(currentAcc.getAccountNumber(), withdraw);
//            }
//            else {
//                System.out.println("Invalid Withdrawal Amount Entered\n\n");
//                router.navigate("/profile"); }
//        } else{
//            System.out.println("Invalid Withdrawal Amount Entered\n\n");
//            router.navigate("/profile");
//        }
//
//        return withdraw;
//    }



    public boolean isValid(Accounts acc){
        if (acc == null) {
            return false;
        } else {
            return true;
        }

    }
}
