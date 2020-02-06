package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repos.ReimbursementRepository;

import java.util.Set;

public class ReimbursementService {

    private ReimbursementRepository reimbursementRepository;

    public ReimbursementService(ReimbursementRepository reimbursementRepository) {
        this.reimbursementRepository = reimbursementRepository;
    }


    public Reimbursement register(Reimbursement newReimbursement){
        System.out.println(newReimbursement);
        if(!isReimbursementValid(newReimbursement)) throw new InvalidRequestException();
        reimbursementRepository.save(newReimbursement);
        return newReimbursement;
    }

    public Set<Reimbursement> getAllReimbursements() {

        return reimbursementRepository.findAll();
    }


    public Set<Reimbursement> getByAuthorId(int id){
        return reimbursementRepository.findAllById(id);
    }

    public boolean update(Reimbursement updateReimbursement){
        return reimbursementRepository.update(updateReimbursement);
    }

    public boolean isReimbursementValid(Reimbursement newReimbursement){
        System.out.println(newReimbursement);

        if (newReimbursement == null) return  false;
        if (newReimbursement.getAmount() == null || newReimbursement.getAmount().trim().equals("")) return false;

        return true;
    }


}