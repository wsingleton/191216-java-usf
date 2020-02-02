package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repos.ReimbursementRepository;

import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ReimbursementService {
    private ReimbursementRepository reimbursementRepository;

    public ReimbursementService(ReimbursementRepository reimbursementRepository) {
        this.reimbursementRepository = reimbursementRepository;
    }

    public void create(Reimbursement newReimbursement) {
        if (!isReimbursementVaild(newReimbursement)) throw new InvalidRequestException();
        reimbursementRepository.save(newReimbursement);
    }

    public Set<Reimbursement> getAllReimbursements() {

        return reimbursementRepository.findAll();
    }


    public Reimbursement getById(int id){
        return reimbursementRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


    public Set<Reimbursement> getByAuthorId(int id){
        return reimbursementRepository.findAllById(id);
    }

    public boolean update(Reimbursement updateReimbursement){
        return reimbursementRepository.update(updateReimbursement);
    }

    public boolean isReimbursementVaild(Reimbursement newReimbursment){
        return true;
    }





//    public SortedSet<Reimbursement> sortUsers(String sortCriterion, Set<User> usersForSorting) {
//
//        SortedSet<User> users = new TreeSet<>(usersForSorting);
//
//        switch (sortCriterion.toLowerCase()) {
//            case "username":
//                users = users.stream()
//                        .collect(Collectors.toCollection(() -> {
//                            return new TreeSet<>(Comparator.comparing(User::getUsername, String::compareTo));
//                        }));
//                break;
//            case "first":
//                users = users.stream()
//                        .collect(Collectors.toCollection(() -> {
//                            return new TreeSet<>(Comparator.comparing(User::getFirstName, String::compareTo));
//                        }));
//                break;
//            case "last":
//                users = users.stream()
//                        .collect(Collectors.toCollection(() -> {
//                            return new TreeSet<>(Comparator.comparing(User::getLastName, String::compareTo));
//                        }));
//                break;
//            case "role":
//                users = users.stream()
//                        .collect(Collectors.toCollection(() -> {
//                            return new TreeSet<>(Comparator.comparing(User::getRole, Enum::compareTo));
//                        }));
//                break;
//            default:
//                throw new InvalidRequestException();
//
//        }
//
//        return users;
//
//    }
//
}