package com.revature.services;

import com.revature.expections.ResourceNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.repos.ReimbursementRepository;

import java.util.Set;

public class ReimbursementService {

    private ReimbursementRepository reimbursementRepository;

    public ReimbursementService(ReimbursementRepository repo) {
        super();
        this.reimbursementRepository = repo;
    }

    public Reimbursement getReimbursementById(int id) {
        return reimbursementRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Reimbursement newReimbursement(Reimbursement reimbursement) {
        //if (!isUserValid(newReimbursement)) throw new InvalidRequestException();
        reimbursementRepository.save(reimbursement);
        return reimbursement;
    }

    public Set<Reimbursement> getAllReimbursements() {
        return reimbursementRepository.findAll();
    }


}
