package com.ers.liberation.services;

import com.ers.liberation.exceptions.InvalidRequestException;
import com.ers.liberation.exceptions.ResourcePersistenceException;
import com.ers.liberation.models.Reimbursement;
import com.ers.liberation.models.Role;
import com.ers.liberation.models.User;
import com.ers.liberation.repos.ReimbursementRepository;

public class ReimbursementService {
    private ReimbursementRepository reimbRepo;

    public ReimbursementService(ReimbursementRepository reimbRepo){
        super();
        this.reimbRepo = reimbRepo;
    }


    public void updateReimbursement(Reimbursement updatedReimb) {

        if (!isReimbValid(updatedReimb)) throw new InvalidRequestException();

        if (reimbRepo.update(updatedReimb)) {
            throw new ResourcePersistenceException("Reimbursement is invalid!");
        }


    }


    public boolean isReimbValid(Reimbursement reimb){

    return true;}
}
