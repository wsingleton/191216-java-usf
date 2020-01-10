package com.revature.services;

import com.revature.models.AccountType;
import com.revature.models.CreditScore;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.UserRepository;


import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static com.revature.MockBankDriver.*;

public class UserService {
    UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static Boolean registerUser(String firstname, String lastname, String username, String password, Boolean jointAccount) throws IOException {
        UserRepository userRepository = new UserRepository();
        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Integer userId = Objects.hashCode(username);
        Random rand = new Random();
        CreditScore tuScore = CreditScore.TRANSUNION, expScore = CreditScore.EXPERIAN;
        tuScore.setScore(rand.nextInt(850-300)+300);
        expScore.setScore(rand.nextInt(tuScore.getScore() - 10)+10);
        User user = new User(userId, firstname, lastname, username, password, Role.MEMBER, tuScore, expScore);
        Boolean bool = userRepository.save(user);
        AccountService.registerAccount(userId, jointAccount);
        if(jointAccount && bool){
            System.out.println("User successfully registered!");
            return true;
        }
        if (bool){
            System.out.println("User successfully registered!");
            router.navigate("/login");
        }else{
            System.out.println("Error creating user!");
            router.navigate("/home");
        }
        return false;

    }

    public void login(String username, String password){
        Integer id = Objects.hashCode(username);
        Integer pw = Objects.hash(password);
        UserRepository userRepository = new UserRepository();
        currentUser = userRepository.findById(id);
        if (pw.toString().equals(currentUser.getPassword())) {
            AccountRepository accountRepository = new AccountRepository();
            accountSet = accountRepository.findById(id);
            router.navigate("/account");
        }else{
            System.out.println("Incorrect username or password!");
            router.navigate("/home");
        }
    }

    //TODO Finish checkCreditScore method in UserService
    public static Integer checkCreditScore(Integer id){
        Integer creditScore = UserRepository.creditScore(id);
        return creditScore;
    }

}
