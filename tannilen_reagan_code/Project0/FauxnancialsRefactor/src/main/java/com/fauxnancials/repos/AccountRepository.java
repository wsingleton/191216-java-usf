package com.fauxnancials.repos;

import com.fauxnancials.models.Acct;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountRepository implements CrudRepository<Acct> {
    public Set<Acct> findByOwner(int id) {
        Set<Acct> accts = new HashSet<>();
        return accts;
    }
    @Override
    public void save(Acct acct) {

    }
    @Override
    public Optional<Acct> findByID(Integer id) {
        return Optional.empty();
    }
    @Override
    public boolean update(Acct acct) {
        return false;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return false;
    }
}