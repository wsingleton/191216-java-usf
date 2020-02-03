package com.revature.repos;

import com.revature.models.Reimbursement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbRepository implements CrudRepository<Reimbursement> {
    private Set<Reimbursement> mapResults(ResultSet results) throws SQLException {
        Set<Reimbursement> reimb = new HashSet<>();
        while (results.next()) {
            Reimbursement temp = new Reimbursement();

        }
    }

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
