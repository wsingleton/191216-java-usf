package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidInputException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repos.ReimbursementRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class ReimbursementService {
    private ReimbursementRepository reimbRepo;
    public ReimbursementService(ReimbursementRepository repo) {
        this.reimbRepo=repo;
    }
    public boolean submitNewReimbursement(double amt, int type, int uID) {
        boolean successful=false;
        Reimbursement reimb=new Reimbursement();
        BigDecimal bd = new BigDecimal(amt).setScale(2, RoundingMode.HALF_UP);
        amt=bd.doubleValue();
        try {
            if (amt<0 || type<1 || type>5) {
                throw new InvalidInputException();
            }
            else {
                reimb.setType(type);
                reimb.setAmt(amt);
                reimb.setAuthID(uID);
                reimb.setSubmitted(System.currentTimeMillis());
                reimb.setStatus(1);
                successful=reimbRepo.save(reimb);
            }
        }
        catch (InvalidInputException e) {
            e.printStackTrace();
        }
        return successful;
    }
    public boolean submitNewReimbursement(double amt, int type, String desc, int uID) {
        boolean successful=false;
        Reimbursement reimb=new Reimbursement();
        BigDecimal bd = new BigDecimal(amt).setScale(2, RoundingMode.HALF_UP);
        amt=bd.doubleValue();
        try {
            if (amt<0 || type<1 || type>5) {
                throw new InvalidInputException();
            }
            else {
                reimb.setType(type);
                reimb.setAmt(amt);
                reimb.setAuthID(uID);
                reimb.setSubmitted(System.currentTimeMillis());
                reimb.setStatus(1);
                reimb.setDesc(desc);
                successful=reimbRepo.save(reimb);
            }
        }
        catch (InvalidInputException e) {
            e.printStackTrace();
        }
        return successful;
    }
    public Set<Reimbursement> viewSubmitted(int uID) {
        System.out.println("View submitted request for User ID " + uID + " in process.");
        Set<Reimbursement> reimbs=reimbRepo.findByAuthor(uID);
        return reimbs;
    }
    public Set<Reimbursement> viewAll(){
        System.out.println("View submitted request for all reimbursements in process.");
        Set<Reimbursement> reimbs=reimbRepo.findAll();
        return reimbs;
    }
    public boolean updateReimb(int reimbID,boolean approved, int resolver) {
        System.out.println("Service request for reimbursement update received.");
        try {
            Reimbursement reimb = reimbRepo.findById(reimbID).orElseThrow(InvalidRequestException::new);
            reimb.setResID(resolver);
            if (approved == true) {
                System.out.println("Reimbursement "+reimbID+" obtained.  Updating status to approved.");
                reimb.setStatus(2);
            } else {
                System.out.println("Reimbursement "+reimbID+" obtained.  Updating status to denied.");
                reimb.setStatus(3);
            }
            boolean updated = reimbRepo.update(reimb);
            return updated;
        }
        catch (InvalidRequestException e) {
            e.printStackTrace();
        }
        return false;
    }
}