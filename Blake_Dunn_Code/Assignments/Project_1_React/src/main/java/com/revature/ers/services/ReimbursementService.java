package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.ReimbursementStatus;
import com.revature.ers.models.ReimbursementType;
import com.revature.ers.repos.ReimbursementRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ReimbursementService {

    private ReimbursementRepository reimbRepo;
    private static final Logger LOG = LogManager.getLogger(ReimbursementService.class);

    public ReimbursementService (ReimbursementRepository repo) {
        super();
        this.reimbRepo = repo;
    }

    public void saveReimb (Reimbursement reimb) {

        Double amount = reimb.getAmount();
        amount = convertAmount(amount);

        LOG.info("Validating reimbursement amount");
        if (amount <= 0) {
            LOG.info("Invalid amount from user, {}", reimb.getAmount());
            throw new InvalidRequestException();
        }
        try{
            LOG.info("Attempting to save new reimbursement request");
            if (reimb.getReceipt() == null) {

                reimbRepo.save(reimb);
            } else {
                InputStream image = new FileInputStream(String.valueOf(reimb.getReceipt()));
            }
        } catch(FileNotFoundException e) {
            LOG.error(e.getMessage());
        }
    }

    public Double convertAmount (Double amount) {

        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        return bigDecimal.setScale(2, RoundingMode.DOWN).doubleValue();

    }

    public Set<Reimbursement> getAllReimbs() {

        Set<Reimbursement> reimbs;
        LOG.info("Attempting to retrieve reimbursements.");
        reimbs = reimbRepo.findAll();

        if (reimbs.isEmpty()) {
            LOG.warn("Request could not be made.");
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Set<Reimbursement> getReimbByStatus(int statusId) {

        Set<Reimbursement> reimbs;

        reimbs = reimbRepo.findReimbByStatus(statusId);

        if (reimbs.isEmpty()) {
            LOG.warn("Request could not be made.");
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Set<Reimbursement> getReimbByType(int typeId) {

        Set<Reimbursement> reimbs;

        reimbs = reimbRepo.findReimbByType(typeId);

        if (reimbs.isEmpty()) {
            LOG.warn("Request could not be made.");
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Set<Reimbursement> getReimbByUser(int userId) {

        Set<Reimbursement> reimbs = reimbRepo.findByUserId(userId);

        if (reimbs.isEmpty()) {
            LOG.warn("Request could not be made.");
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Reimbursement getReimbById (int reimbId) {
        LOG.info("Retrieving reimbursement info by id, {}", reimbId);
        return reimbRepo.findById(reimbId).orElseThrow(ResourceNotFoundException::new);
    }

    public SortedSet<Reimbursement> sortReimbs(String sortCriterion, Set<Reimbursement> reimbsForSorting) {

        SortedSet<Reimbursement> reimbs = new TreeSet<>(reimbsForSorting);
        LOG.info("Sorting reimbursements by {}", sortCriterion);
        switch (sortCriterion.toLowerCase()) {
            case "author":
                reimbs = reimbs.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(Reimbursement::getAuthorId, Integer::compareTo));
                        }));
                break;
            case "status":
                reimbs = reimbs.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(Reimbursement::getStatus, ReimbursementStatus::compareTo));
                        }));
                break;
            case "type":
                reimbs = reimbs.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(Reimbursement::getType, ReimbursementType::compareTo));
                        }));
                break;
            case "amount":
                reimbs = reimbs.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(Reimbursement::getAmount, Double::compareTo));
                        }));
                break;
            default:
                LOG.warn("Could not sort based on the user request");
                throw new InvalidRequestException();
        }

        LOG.info("Reimbursements were successfully sorted");
        return reimbs;
    }

    public Boolean updateReimbursement(Reimbursement updatedReimb) {

        if (updatedReimb.getStatus() == ReimbursementStatus.PENDING) {
            LOG.warn("Manager did not update reimbursement status");
            throw new InvalidRequestException();
        }

        reimbRepo.update(updatedReimb);
        LOG.info("Reimbursement was updated.");
        return true;
    }

}
