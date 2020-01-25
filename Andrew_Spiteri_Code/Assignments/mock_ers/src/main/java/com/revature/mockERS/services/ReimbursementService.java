package com.revature.mockERS.services;

import com.revature.mockERS.dto.ReimbursementIn;
import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.models.ERS_Reimbursement_Status;
import com.revature.mockERS.models.ERS_Reimbursement_Type;
import com.revature.mockERS.repositories.ReimbursementRepository;

import java.sql.Timestamp;
import java.util.Date;

public class ReimbursementService {
    private ReimbursementRepository rr = new ReimbursementRepository();

    public ReimbursementService(ReimbursementRepository rr){
        this.rr = rr;
    }

    public Boolean createNew(ReimbursementIn ri){
        Date date = new Date();
        ERS_Reimbursement ers_reimbursement = new ERS_Reimbursement();
        ers_reimbursement.setReimb_amount(ri.getAmount());
        ers_reimbursement.setReimb_submitted(new Timestamp(date.getTime()));
        ers_reimbursement.setReimb_description(ri.getDesc());
        ers_reimbursement.setStatus(ERS_Reimbursement_Status.PRESPROCESSING);
        //TODO CREATE FIELD FOR TYPE
        ers_reimbursement.setType(ERS_Reimbursement_Type.valueOf(ri.getType().toUpperCase()));

        return rr.addReimbursement(ers_reimbursement);
    }
}
