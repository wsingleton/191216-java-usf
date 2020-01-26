package com.revature.ers.repositories;

import com.revature.ers.models.Reimbursement;

import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {
    @Override
    public void save(Reimbursement newObj) {

    }

    @Override
    public Set<Reimbursement> findAll() {
        return null;
    }

    @Override
    public Optional<Reimbursement> findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Reimbursement updatedObj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
