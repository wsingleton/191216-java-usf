package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.repos.ReimbRepository;

public class ReimbService {
    private ReimbRepository rRepo;

    public ReimbService(ReimbRepository rRepo) {
        this.rRepo = rRepo;
    }

    public Reimbursement getById(int id) throws ResourceNotFoundException {
        return rRepo.findById(id).orElseThrow(ResourceNotFoundException::new);

    }

    public Reimbursement addReimbReq(Reimbursement reimb) {
        rRepo.save(reimb);
        return reimb;
    }
}
