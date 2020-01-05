package com.revature.fauxbank.repos;

import com.revature.fauxbank.models.Account;
import com.revature.fauxbank.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountRepository implements CrudRepository<Account> {

    private Integer key;
    private HashMap<Integer, Account> acctDb;

    public Optional findByAccountNumber(Integer accountNumber) {

        for (Map.Entry<Integer, Account> entry : acctDb.entrySet()) {
            if (entry.getValue().getAccountNumber().equals(accountNumber)) {
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    @Override
    public void save(Account newAccount) {

        newAccount.setId(key);
        acctDb.put(key++, newAccount);

    }

    @Override
    public Optional<Account> findById(Integer id) {

        for (Map.Entry<Integer, Account> entry : acctDb.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(Account updateObj) {

        if (acctDb.get(updateObj.getId()) == null) return false;
        acctDb.put(updateObj.getId(), updateObj);
        return true;

    }
}
