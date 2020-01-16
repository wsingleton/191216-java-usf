package com.revature.services;

import static com.revature.BankMain.currentUser;
import com.revature.exceptions.DuplicateException;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.InvalidEntryException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.util.ConnectionMaker;
import com.revature.util.UserConnection;

public class UserServices {

    private UserRepository uRepo;

    public UserServices(UserRepository uRepo) {
        super();
        this.uRepo = uRepo;
    }

    public void register(User newUser) {

        if (!UserValidation(newUser)) throw new InvalidCredentialsException();

        if (uRepo.findByUsername(newUser.getUsername()).isPresent()) {
            throw new DuplicateException();
        }

        uRepo.save(newUser);
    }

    public void login(String username, String password) {
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidEntryException();
        }

        currentUser = uRepo.findByCredentials(username, password).orElseThrow(InvalidCredentialsException::new);

    }

    public boolean UserValidation (User user) {

        if (user == null) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }


}
