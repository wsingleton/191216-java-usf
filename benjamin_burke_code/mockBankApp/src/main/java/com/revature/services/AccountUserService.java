//package com.revature.services;
//
//import com.revature.models.AccountUser;
//import com.revature.repos.AccountRepository;
//import com.revature.repos.AccountUserRepository;
//
//public class AccountUserService {
//    private AccountRepository accRepo;
//    private AccountUserRepository accountUserRepository;
//
//    public AccountService(){super();}
//
//    public AccountUserService(AccountRepository accRepo) {
//        this.accRepo = accRepo;
//    }
//
//    public void register(int userId, int accountId) {
//        AccountUser accountUser = new AccountUser(userId, accountId);
//        accountUserRepository.save(accountUser);
//    }
//}
