package com.revature.mockbank;

import com.revature.mockbank.models.*;
import com.revature.mockbank.repositories.AccountRepo;
import com.revature.mockbank.repositories.TransactionRepo;
import static com.revature.mockbank.repositories.AccountRepo.*;

import java.time.LocalDateTime;
import java.util.*;

public class Test {

    public static void main (String... args){
//        Account myAccount = new Account();
//        myAccount.setAccount_id(1);
//        myAccount.setAccount_type(AccountType.CHECKING);
//        myAccount.setAccount_access(AccountAccess.SHARED);
//        myAccount.setBalance(30.0);
//        //System.out.println(myAccount.toString());
//        AccountRepo acRepo = new AccountRepo();
//        acRepo.save(myAccount);

//        TransactionRepo tr = new TransactionRepo();
//
//
//        Set<TransactionHistory> his = tr.findActivityById(61);
//        if(his.size() !=0 ){
//            for (TransactionHistory activity : his){
//                System.out.println(activity);
//            }
//        } else {
//            System.out.println("No record found");
//        }

        ;
        try{
            AccountRepo repo = new AccountRepo();
            repo.findAllAccounts(61);
            System.out.println(repo.findAllAccounts(61).size());
            System.out.println(usersAccounts.toString());

            //UserAccounts accList = new UserAccounts();
            //ArrayList<Integer> accounts = accList.getAccountList();
            //System.out.println(accounts.size());


//            System.out.println(accounts);
            for(int account: usersAccounts){
                System.out.println("Account number: " + account);
            }


//            ArrayList<Integer> accounts = usersAccounts;
//            System.out.println(usersAccounts.size());

//            if(usersAccounts.isEmpty()){
//                System.out.println("No accounts found");
//            } else{
//                for(int i = 0; i<usersAccounts.size(); i++){
//                    System.out.println(usersAccounts.get(i));
//                }
//            }
        }catch(Exception e){
            e.printStackTrace();
        }



//        Set<TransactionHistory> hist = new HashSet<>();
//        hist= tr.findById(32);
        //System.out.println(history);

    }
}
