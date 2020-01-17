package com.revature.bank.services;

import com.revature.bank.exceptions.AuthenticatironException;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.models.UserAcct;
import com.revature.bank.repos.UserAcctRepository;

import static com.revature.bank.AppDriver.*;

public class UserAcctService {

    private UserAcctRepository userAcctRepo;

    public UserAcctService(UserAcctRepository repo){ this.userAcctRepo = repo; }

    public void authenticate(Integer userId, Integer acctId){
        if(userId == null || userId.equals("") || acctId == null || acctId.equals("")){
            throw new InvalidRequestException();
        }
        currentUserAcct = userAcctRepo.findByCredentials(userId, acctId).orElseThrow(AuthenticatironException::new)
    }

    public UserAcctRepository getUserAcctRepo(Integer userId) {
        if(userId == null || userId.equals("")){
            throw new InvalidRequestException();
        }
        if(userAcctRepo.findById(userId).isPresent()) {
            currentUserAcct = userAcctRepo.findById(userId).orElseThrow(AuthenticatironException::new);
        }
        else{
            Integer acctId =
            UserAcct userAcct = new UserAcct(userId, acctId)


        }
        return userAcctRepo;
    }
}
