package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repositories.ReimbursementRepository;

import java.util.Set;

public class ReimbursementService {
    private ReimbursementRepository reimbursementRepository;

    public ReimbursementService(ReimbursementRepository reimbursementRepository) {
        this.reimbursementRepository = reimbursementRepository;
    }

    public void create(Reimbursement newReimbursement) {
        if( !isReimbursementValid(newReimbursement)) throw new InvalidRequestException();
        reimbursementRepository.save(newReimbursement);
    }

    public Set<Reimbursement> getAllReimbursements() {
        Set<Reimbursement> reimbursements;
        reimbursements = reimbursementRepository.findAll();

        if(reimbursements.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return reimbursements;
    }

    public Reimbursement getById(int id) {
        return reimbursementRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Set<Reimbursement> getByAuthorId(int id) {
        return reimbursementRepository.findByAuthorId(id);
    }

    public boolean update(Reimbursement updatedReimbursement) {
        return reimbursementRepository.update(updatedReimbursement);
    }

    public boolean isReimbursementValid(Reimbursement newReimbursement) {
        return true;
    }
}
