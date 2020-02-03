package com.revature.services;

import com.revature.expections.InvalidRequestException;
import com.revature.expections.ResourceNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.repos.ReimbursementRepository;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ReimbursementService {

    private ReimbursementRepository reimbursementRepository;

    public ReimbursementService(ReimbursementRepository repo) {

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

    public Set<Reimbursement> getByAuthorId(int id) {
        return reimbursementRepository.findAllById(id);
    }

    public boolean update(Reimbursement updateReimbursement){
        return reimbursementRepository.update(updateReimbursement);
    }


}







