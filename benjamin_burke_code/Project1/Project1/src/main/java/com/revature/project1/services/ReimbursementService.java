package com.revature.project1.services;

import com.revature.project1.exceptions.InvalidRequestException;
import com.revature.project1.exceptions.ResourceNotFoundException;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Status;
import com.revature.project1.repos.ReimbursementRepository;

import java.util.Set;

public class ReimbursementService {

    private ReimbursementRepository reimbRepo;

    public ReimbursementService(ReimbursementRepository repo) {
        super();
        this.reimbRepo = repo;
    }

    public void register(Reimbursement newReimb) {

        if (!isReimbursementValid(newReimb)) throw new InvalidRequestException();

        newReimb.setStatus(Status.PENDING);
        reimbRepo.save(newReimb);

    }

    public Set<Reimbursement> getReimbursementsByStatus(Status status) {

        Set<Reimbursement> reimbursements;

        if (status == null) {
            throw new InvalidRequestException();
        }

        reimbursements = reimbRepo.findReimbursementsByStatus(status);

        if (reimbursements.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return reimbursements;

    }

    public Set<Reimbursement> getReimbursementsByUserId(int id) {

        Set<Reimbursement> reimbursements;

        if (id <= 0) {
            throw new InvalidRequestException();
        }

        reimbursements = reimbRepo.findReimbursementsByAuthorId(id);

        if (reimbursements.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return reimbursements;

    }

    public Boolean updateReimbursement(Reimbursement updatedReimb) {

        Boolean reimbursementUpdated;

        if (!isReimbursementValid(updatedReimb)) {
            throw new InvalidRequestException();
        }

        reimbursementUpdated = reimbRepo.update(updatedReimb);

        return reimbursementUpdated;

    }

    public Boolean isReimbursementValid(Reimbursement reimb) {
        if (reimb == null) return false;
        if (reimb.getAmount() == null || reimb.getAmount() <= 0) return false;
//        if (reimb.getAuthorId() == null) return false;
        if (reimb.getType() == null) return false;
        return true;
    }

}
