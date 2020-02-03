package com.revature.project1.services;

import com.revature.project1.exceptions.InvalidRequestException;
import com.revature.project1.exceptions.ResourceNotFoundException;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Status;
import com.revature.project1.repos.ReimbursementRepository;

import java.util.Set;

public class ReimbursementService  {

    private ReimbursementRepository reimbRepo;

    public ReimbursementService(ReimbursementRepository repo) {
        super();
        this.reimbRepo = repo;
    }


    public Reimbursement getReimbById(int id) {
        return reimbRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }





    public Set<Reimbursement> getAllReimb(){
        Set<Reimbursement> reimb;
        reimb = reimbRepo.findAll();

        if(reimb.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return reimb;
    }


    public Set<Reimbursement> getReimbByUser(int userId) {

        Set<Reimbursement> reimbs = reimbRepo.findByUserId(userId);

        if (reimbs.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }


    public Reimbursement saveReimb(Reimbursement reimb) {
        reimbRepo.save(reimb);
        return reimb;
    }

//    public Boolean updateReimbursement(Reimbursement updatedReimb) {
//
//        if (updatedReimb.getStatus() == Status.PENDING) {
//            throw new InvalidRequestException();
//        }
//
//        reimbRepo.update(updatedReimb);
//        return true;
//    }


    public Boolean updateReimbursement(Reimbursement updatedReimb) {

        Boolean reimbursementUpdated;

        if (!isReimbursementValid(updatedReimb)) {
            throw new InvalidRequestException();
        }

        reimbursementUpdated = reimbRepo.update(updatedReimb);

        return reimbursementUpdated;

    }

    public Set<Reimbursement> getStatusByStatus(Status status) {

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

    public Boolean isReimbursementValid(Reimbursement reimb) {
        if (reimb == null) return false;
        if (reimb.getAmount() == null || reimb.getAmount() <= 0) return false;
//        if (reimb.getAuthorId() == null) return false;
        if (reimb.getType() == null) return false;
        return true;
    }





    //get reimbursement by status
    //get reimbursement by Type
    //get reimbursement by User
    // update reimbursement
    //get all reimbursement
    //save reimbursement
}

