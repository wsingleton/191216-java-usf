package com.revature.repos;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Optional;

public class AccountRepository {

    public Optional<Account> findByUsername(String Username) {
        Optional<Account> account = Optional.empty();


    }
}
