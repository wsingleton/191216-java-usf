package com.revature.mockERS.services;

import com.revature.mockERS.dto.ChangeStatusIn;
import com.revature.mockERS.dto.ReimbursementIn;
import com.revature.mockERS.dto.ReimbursementOut;
import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.models.ERS_Reimbursement_Status;
import com.revature.mockERS.models.ERS_Reimbursement_Type;
import com.revature.mockERS.repositories.ReimbursementRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    public List<ReimbursementOut> returnAllUnprocessedReimbs(){
        return rr.getAllUnprocessedReimbs();
    }

    public Set<ReimbursementOut> returnReimbursementByUser(Integer id){
        return rr.getReimbursementByUser(id);
    }

    public Boolean updateStatus(ChangeStatusIn csi){
        ERS_Reimbursement ers = ERS_Reimbursement.makeReimbursement();
        ers.setStatus(ERS_Reimbursement_Status.getStatusByName(csi.getStatus()));
        ers.setReimbId(csi.getId());
        return rr.updateReimbStatus(ers);
    }

}


