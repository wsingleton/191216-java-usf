package com.liberationbank.repos;

import com.liberationbank.models.Account;
import com.liberationbank.models.AccountType;
import com.liberationbank.models.User;


import java.util.*;

public class AccountRepository implements CrudRepository<Account> {
    private Integer key;
    private HashMap<Integer, Account> accountDb;

    public Set<Account> findAccountsByAccountType(AccountType accountType) {
        HashSet<Account> accounts = new HashSet<>();
        //example of a lambda expression
        accountDb.forEach((key, value) -> {
            if (value.getAccountType().equals(accountType)) {
                accounts.add(value);
            }
        });
        return accounts;
    }

    public Optional<Account> findByAccountNumber(Account account) {
        for (Map.Entry<Integer, Account> entry : accountDb.entrySet()) {
            if (entry.getValue().getAccountNumber().equals(account.getAccountNumber())) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

//    public Optional<Book> findByAuthorLastName(String authorlastname) {
//        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
//            if (entry.getValue().getAuthor().getLastName().equals(authorlastname)) {
//                return Optional.of(entry.getValue());
//            }
//        }
//        return Optional.empty();
//    }
//
//    public Optional<Book> findByIsbn(String isbn) {
//        for (Map.Entry<Integer, Book> entry : bookDb.entrySet()) {
//            if (entry.getValue().getIsbn().equals(isbn)) {
//                return Optional.of(entry.getValue());
//            }
//        }
//        return Optional.empty();
//    }


    @Override
    public void save(Account newObj) {
        newObj.setId(key);
        accountDb.put(key++, newObj);
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
    public Boolean update(Account updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}


