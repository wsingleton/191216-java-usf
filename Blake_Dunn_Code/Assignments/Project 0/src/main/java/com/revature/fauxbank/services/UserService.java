package com.revature.fauxbank.services;

import com.revature.fauxbank.exceptions.*;
import com.revature.fauxbank.models.*;
import com.revature.fauxbank.repos.*;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.revature.fauxbank.BankDriver.*;

public class UserService {

    private UserRepository userRepo;
    private AccountRepository acctRepo;

    public UserService() {

    }

    public UserService(UserRepository uRepo, AccountRepository aRepo) {
        this.userRepo = uRepo;
        this.acctRepo = aRepo;
    }

    public void authenticate (String username, String password) {

        if (username == null || username.trim().equals("")
            || password == null || password.trim().equals("")) throw new InvalidRequestException();

        currentUser = userRepo.getUser(username, password);
        currentAccount = acctRepo.getAccount();
    }

    public void register(User user) {

        if (!isUserValid(user)) throw new InvalidRequestException();

        if (userRepo.findUserByUserName(user.getUserName()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }

        currentUser = userRepo.save(user);


    }

    public void setNewAccount(String type) {
        Account newAccount = new Account(0.0);

        switch(type){
            case "1":
                newAccount.setAccountType(AccountType.CHECKING);
                break;
            case "2":
                newAccount.setAccountType(AccountType.SAVINGS);
                break;
            default:
                System.out.println("Invalid selection");
                appRunning = false;
        }

        currentAccount = acctRepo.save(newAccount);
        userRepo.updateCompositeKey();
    }

    public boolean isUserValid(User user) {

        int s = 7;
        int l = 15;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(user.getPassword());

        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")
                || !(user.getFirstName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")
                || !(user.getLastName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("")
                || user.getUserName().length() <= s || user.getUserName().length() >= l) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")
                || user.getPassword().length() <= s || user.getPassword().length() >= l) {
            System.out.println("Error: Password must be between 8-14 characters");
            return false;
        }
        if (matcher.matches()){
            System.out.println("Error: Password must contain a special character.");
            return false;
        }
        return true;
    }
}
