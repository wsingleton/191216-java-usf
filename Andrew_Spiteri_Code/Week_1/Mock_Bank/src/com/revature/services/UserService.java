package com.revature.services;

import com.revature.models.AccountType;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.UserRepository;


import java.io.IOException;
import java.util.Objects;

import static com.revature.MockBankDriver.*;

public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void registerUser(String firstname, String lastname, String username, String password) throws IOException {
        UserRepository userRepository = new UserRepository();
        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Integer userId = Objects.hashCode(username);
        User user = new User(userId, firstname, lastname, username, password, Role.MEMBER);
        Boolean bool = userRepository.save(user);
        accountService.registerAccount(userId);
        if (bool){
            System.out.println("User successfully registered!");
            router.navigate("/login");
        }
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

    public Integer checkCreditScore(Integer id){
        UserRepository userRepository = new UserRepository();

        return 0;
    }

}
