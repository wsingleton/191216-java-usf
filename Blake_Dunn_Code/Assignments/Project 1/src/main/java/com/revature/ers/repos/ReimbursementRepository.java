package com.revature.ers.repos;

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
    public Optional<Reimbursement> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Reimbursement updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
