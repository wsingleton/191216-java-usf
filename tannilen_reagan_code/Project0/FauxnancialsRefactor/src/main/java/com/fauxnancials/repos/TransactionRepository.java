package com.fauxnancials.repos;

import com.fauxnancials.models.Transaction;

import java.util.Optional;
import java.util.Set;

public class TransactionRepository implements CrudRepository<Transaction> {
    @Override
    public void save(Transaction transaction) {

    }
    public Set<Transaction> findAll() {
        return null;
    }
    @Override
    public Optional<Transaction> findByID(Integer id) {
        return Optional.empty();
    }
    @Override
    public boolean update(Transaction transaction) {
        return false;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return false;
    }
}
