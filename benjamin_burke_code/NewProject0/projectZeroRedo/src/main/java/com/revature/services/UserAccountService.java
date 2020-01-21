package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.repos.UserAccountRepository;
import com.revature.models.UserAccount;

import static com.revature.AppDriver.*;

public class UserAccountService {

    private UserAccountRepository userAccRepo;

    public UserAccountService(UserAccountRepository repo){ this.userAccRepo = repo;}

//    public void authenticate(Integer userId, Integer accountNumber){
//        if(userId == null || userId.equals("") || accountNumber == null || accountNumber.equals("")){
//            throw new InvalidRequestException();
//        }
//        currentUserAcc = userAccRepo.findByCredentials(userId, accountNumber).orElseThrow(AuthenticationException::new);
//    }

//    public UserAccountRepository getUserAccRepo(Integer userId) {
//        if(userId == null || userId.equals("")){
//            throw new InvalidRequestException();
//        }
//        if(userAccRepo.findById(userId).isPresent()) {
//            currentUserAcc = userAccRepo.findById(userId).orElseThrow(AuthenticationException::new);
//        }
//        else{
//            Integer accountNumber =
//                    UserAccount acc = new UserAccount(userId, accountNumber);
//
//
//        }
//        return userAccRepo;
//    }
}
