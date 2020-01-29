package com.revature.reimbursement_app.services;

import com.revature.reimbursement_app.exceptions.InvalidRequestException;
import com.revature.reimbursement_app.exceptions.ResourceNotFoundException;
import com.revature.reimbursement_app.models.Reimbursement;
import com.revature.reimbursement_app.models.ReimbursementStatus;
import com.revature.reimbursement_app.models.User;
import com.revature.reimbursement_app.repos.ReimbursementRepo;

import java.util.Optional;
import java.util.Set;

public class ReimbursementService {

    private ReimbursementRepo reimbRepo;

    public ReimbursementService(ReimbursementRepo repo) {
        super();
        this.reimbRepo = repo;
    }

    public void register(Reimbursement newReimb) {

        if (!isReimbursementValid(newReimb)) throw new InvalidRequestException();

        newReimb.setStatus(ReimbursementStatus.PENDING);
        reimbRepo.save(newReimb);

    }

    public Set<Reimbursement> getReimbursementsByStatus(ReimbursementStatus status) {

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

    public Set<Reimbursement> getReimbursementsByUser(User user) {

        Set<Reimbursement> reimbursements;

        if (user == null) {
            throw new InvalidRequestException();
        }

        reimbursements = reimbRepo.findReimbursementsByAuthorId(user);

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
        if (reimb.getAuthorId() == null) return false;
        if (reimb.getType() == null) return false;
        return true;
    }

}
