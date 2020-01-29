package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.ReimbursementStatus;
import com.revature.ers.models.ReimbursementType;
import com.revature.ers.repos.ReimbursementRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ReimbursementService {

    private ReimbursementRepository reimbRepo;

    public ReimbursementService (ReimbursementRepository repo) {
        super();
        this.reimbRepo = repo;
    }

    public void saveReimb (Reimbursement reimb) {

        try{
            if (reimb.getReceipt() == null) {
                reimbRepo.save(reimb);
            } else {
                InputStream image = new FileInputStream(String.valueOf(reimb.getReceipt()));
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Set<Reimbursement> getAllReimbs() {

        Set<Reimbursement> reimbs;

        reimbs = reimbRepo.findAll();

        if (reimbs.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Set<Reimbursement> getReimbByStatus(int statusId) {

        Set<Reimbursement> reimbs;

        reimbs = reimbRepo.findReimbByStatus(statusId);

        if (reimbs.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Set<Reimbursement> getReimbByType(int typeId) {

        Set<Reimbursement> reimbs;

        reimbs = reimbRepo.findReimbByType(typeId);

        if (reimbs.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Set<Reimbursement> getReimbByUser(int typeId) {

        Set<Reimbursement> reimbs;

        reimbs = reimbRepo.findByUserId(typeId);

        if (reimbs.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return reimbs;
    }

    public Reimbursement getReimbById (int reimbId) {
        return reimbRepo.findById(reimbId).orElseThrow(ResourceNotFoundException::new);
    }

    public SortedSet<Reimbursement> sortReimbs(String sortCriterion, Set<Reimbursement> reimbsForSorting) {

        SortedSet<Reimbursement> reimbs = new TreeSet<>(reimbsForSorting);

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
                throw new InvalidRequestException();
        }

        return reimbs;
    }

    public Boolean updateReimbursement(Reimbursement updatedReimb) {

        if (updatedReimb.getStatus() == ReimbursementStatus.PENDING) {
            throw new InvalidRequestException();
        }

        reimbRepo.update(updatedReimb);
        return true;
    }

}
