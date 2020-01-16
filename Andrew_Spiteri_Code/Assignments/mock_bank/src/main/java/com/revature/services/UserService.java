package com.revature.services;

import com.revature.models.AccountType;
import com.revature.models.CreditScore;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.UserRepository;


import java.io.IOException;
import java.util.*;

import static com.revature.MockBankDriver.*;

public class UserService {
    UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static Boolean registerUser( Boolean jointAccount, User... users) throws IOException {
        UserRepository userRepository = new UserRepository();
        Random rand = new Random();

        Set<User> userSet = new HashSet<>();
        Integer isJoint;
        if(jointAccount){
            isJoint =1;
        }else {
            isJoint = 0;
        }
        for(int i = 0; i < users.length; i++) {
            Integer userId = Objects.hashCode(users[i].getUserName());
            CreditScore tuScore = CreditScore.TRANSUNION, expScore = CreditScore.EXPERIAN;
            tuScore.setScore(rand.nextInt(850 - 300) + 300);
            expScore.setScore(rand.nextInt(10) + tuScore.getScore());
            User user = new User(userId, users[i].getFirstName(), users[i].getLastName(), users[i].getUserName(), users[i].getPassword(), Role.MEMBER, tuScore.getScore(), expScore.getScore());
            userSet.add(user);
        }
        Boolean bool = userRepository.save(userSet, isJoint);
        for (User u:
             userSet) {
            AccountService.registerAccount(u.getID(), jointAccount);
        }
        if (bool) {
            System.out.println("User successfully registered!");
            router.navigate("/login");
        } else {
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
    public static ArrayList<Integer> checkCreditScore(Integer id){
        return UserRepository.creditScore(id);
    }

}
