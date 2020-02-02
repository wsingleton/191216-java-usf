package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.User;
import com.revature.ers.repositories.ReimbursementRepository;
import com.revature.ers.servlets.AuthServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ReimbursementService {
    private ReimbursementRepository reimbursementRepository;
    private static final Logger LOG = LogManager.getLogger(ReimbursementService.class);


    public ReimbursementService(ReimbursementRepository reimbursementRepository) {
        this.reimbursementRepository = reimbursementRepository;
    }

    public void create(Reimbursement newReimbursement, User user) {
        LOG.info("Service layer validation for reimbursement creation");
        if( !isReimbursementValid(newReimbursement)) {
            LOG.warn("Validation Failed");
            throw new InvalidRequestException();
        }
        LOG.info("Validation Successful");
        reimbursementRepository.save(newReimbursement, user);
    }

    public Set<Reimbursement> getAllReimbursements(User user) {
        LOG.info("Getting all reimbursements");
        Set<Reimbursement> reimbursements;
        reimbursements = reimbursementRepository.findAll(user);

        if(reimbursements.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return reimbursements;
    }

    public Set<Reimbursement> getAllBut(int id, User user) {
        LOG.info("Service layer getting all reimbursements that do not belong to current user");
        Set<Reimbursement> reimbursements;
        reimbursements = reimbursementRepository.getAllBut(id, user);

        if(reimbursements.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return reimbursements;
    }

    public Reimbursement getById(int id, User user) {
        LOG.info("Service layer get reimbursement by id");
        return reimbursementRepository.findById(id, user).orElseThrow(ResourceNotFoundException::new);
    }

    public Set<Reimbursement> getByAuthorId(int id, User user) {
        LOG.info("Service layer get reimbursements by author id");
        return reimbursementRepository.findByAuthorId(id, user);
    }

    public boolean update(Reimbursement updatedReimbursement, User user) {
        LOG.info("Service layer updating user");
        return reimbursementRepository.update(updatedReimbursement, user);
    }

    public boolean isReimbursementValid(Reimbursement newReimbursement) {
        return true;
    }
}
