package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.repos.ReimbRepository;

import java.util.Set;

public class ReimbService {
    private ReimbRepository rRepo;

    public ReimbService(ReimbRepository rRepo) {
        this.rRepo = rRepo;
    }

    public Set<Reimbursement> getById(int id) throws ResourceNotFoundException {
        return rRepo.newFindById(id);

    }

    public Set<Reimbursement> getByAuthorId (int id) {
        return rRepo.newFindById(id);
    }

    public Reimbursement addReimbReq(Reimbursement reimb) {
        rRepo.save(reimb);
        return reimb;
    }

    public Set<Reimbursement> getAllReimb(){
         return rRepo.findAll();
    }

    public boolean update(Reimbursement reimb) {
        return rRepo.update(reimb);
    }


}
