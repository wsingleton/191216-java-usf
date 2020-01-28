package com.revature.ers.services;

import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repos.ReimbursementRepository;

import java.util.Set;

public class ReimbursementService {

    private ReimbursementRepository reimbRepo;

    public ReimbursementService(ReimbursementRepository repo) {
        this.reimbRepo = repo;
    }

    public Reimbursement getReimbursementById(int id) throws ResourceNotFoundException {
        return reimbRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Set<Reimbursement> getAllReimbursements(){
        return reimbRepo.findAll();
    }

    public Reimbursement createReimbursement(Reimbursement reimb) {
        reimbRepo.save(reimb);
        return reimb;
    }
    
}
