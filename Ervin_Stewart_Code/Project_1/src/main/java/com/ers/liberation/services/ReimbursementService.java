package com.ers.liberation.services;

import com.ers.liberation.exceptions.InvalidRequestException;
import com.ers.liberation.exceptions.ResourcePersistenceException;
import com.ers.liberation.models.Reimbursement;
import com.ers.liberation.models.ReimbursementStatus;
import com.ers.liberation.models.Role;
import com.ers.liberation.models.User;
import com.ers.liberation.repos.ReimbursementRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class ReimbursementService {
    private ReimbursementRepository reimbRepo;

    public ReimbursementService(ReimbursementRepository reimbRepo){
        super();
        this.reimbRepo = reimbRepo;
    }

    public Set<Reimbursement> getReimbursements4Employee(User user){
       Set<Reimbursement> reimbursements =  reimbRepo.findReimbursementsById(user.getId());
       if(reimbursements.isEmpty()){
           throw new ResourcePersistenceException();
       }
        return reimbursements;
    }

    public Set<Reimbursement> getAllReimbursements(){
        Set<Reimbursement> reimbursements =  reimbRepo.findAll();
        if(reimbursements.isEmpty()){
            throw new ResourcePersistenceException();
        }
        return reimbursements;
    }


    public void addNewReimbursement(Reimbursement newReimbursement){
        newReimbursement.setDescription(newReimbursement.getDescription().trim());
        if(!isReimbValid(newReimbursement)) {throw new InvalidRequestException();}
     newReimbursement.setAmount(sanitizeValue(newReimbursement.getAmount()));
       newReimbursement.setStatus(ReimbursementStatus.PENDING);
        reimbRepo.save(newReimbursement);

    }

    public Boolean updateReimbursement(Reimbursement updatedReimb) {
        Boolean reimbursementUpdated;

        reimbursementUpdated = reimbRepo.update(updatedReimb);

        return reimbursementUpdated;
    }

    public boolean validateReimbAmount( double amount){
        if(amount < 0 || amount >5000 ){ return false; }
        return true;
    }

    public double sanitizeValue(double amount){
        BigDecimal bd = new BigDecimal(amount).setScale(2, RoundingMode.DOWN);
        double formattedAmount = bd.doubleValue();
        return formattedAmount;
    }

    public boolean isReimbValid(Reimbursement reimb){

    return true;
    }


    public boolean isValidDescriptionLength(String description){
        if(description.length() >=251){return true;}
        return false;
    }


}
