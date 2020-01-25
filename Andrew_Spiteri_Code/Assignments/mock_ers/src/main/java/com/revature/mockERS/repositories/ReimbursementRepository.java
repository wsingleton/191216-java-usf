package com.revature.mockERS.repositories;

import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.util.UserSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.revature.mockERS.util.ConnectionFactory.getCon;

public class ReimbursementRepository {
    public Boolean addReimbursement(ERS_Reimbursement reimb){

        String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description,reimb_author, reimb_status_id, reimb_type_id) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setBigDecimal(1, reimb.getReimb_amount());
            ps.setTimestamp(2, reimb.getReimb_submitted());
            ps.setString(3, reimb.getReimb_description());
            ps.setInt(4, UserSession.getSessionUser().getId());
            ps.setInt(5, reimb.getStatus().getId());
            ps.setInt(6, reimb.getType().getId());
            Integer success = ps.executeUpdate();
            if(success == 1){
                return true;
            }
        }catch (SQLException e){

            e.printStackTrace();
        }
        return false;
    }
}
