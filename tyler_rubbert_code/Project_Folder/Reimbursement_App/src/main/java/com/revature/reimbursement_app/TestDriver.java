package com.revature.reimbursement_app;

import com.revature.reimbursement_app.models.*;
import com.revature.reimbursement_app.repos.ReimbursementRepo;
import com.revature.reimbursement_app.repos.UserRepository;

public class TestDriver {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();
        ReimbursementRepo reimbRepo = new ReimbursementRepo();

//        System.out.println("find all:");
//        for (Reimbursement r : reimbRepo.findAll()) System.out.println(r.toString());
//        System.out.println("+-----------------------------------+");
//
//        System.out.println("find by id:");
//        System.out.println(reimbRepo.findById(1));
//        System.out.println("+----------------------------+");
//
//        System.out.println("find by author id:");
//        System.out.println(reimbRepo.findReimbursementsByAuthorId(repo.findById(4).get()));
//        System.out.println("+----------------------------+");
//
//        System.out.println("find by status");
//        for (Reimbursement r : reimbRepo.findReimbursementsByStatus(ReimbursementStatus.PENDING)) System.out.println(r.toString());
//        System.out.println("+----------------------------+");

        System.out.println("add reimbursement: ");
        Reimbursement reimb = new Reimbursement(85.37,"Business lunch with clients",4, ReimbursementType.FOOD);
        System.out.println("before save: " + reimb);
        reimbRepo.save(reimb);
        System.out.println("after save: " + reimb);
//        System.out.println("+----------------------------+");



//        System.out.println("update reimb:");
//        Reimbursement updatedReimb = reimbRepo.findById(1).get();
//        updatedReimb.setStatus(ReimbursementStatus.APPROVED);
//        updatedReimb.setResolverId(1);
//        System.out.println("update successful: " + reimbRepo.update(updatedReimb));
//        System.out.println("confirming update: " + reimbRepo.findById(1));
//        System.out.println("+----------------------------+");

    }

}
