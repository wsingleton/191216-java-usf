package com.revature.bank.repos;

import com.revature.bank.models.Account;

import java.util.Optional;
import java.util.Set;

public class AcctRepository implements CrudRepository<Account> {
    @Override
    public void save(Account newObj) {
        return;
    }

    @Override
    public Set<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Account updateObj) {
        return null;
    }
}
