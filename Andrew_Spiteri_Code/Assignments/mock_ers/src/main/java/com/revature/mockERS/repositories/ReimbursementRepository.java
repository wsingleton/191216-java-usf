package com.revature.mockERS.repositories;

import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.models.ERS_Users;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.revature.mockERS.util.ConnectionFactory.getCon;

public class ReimbursementRepository {
    public Boolean addReimbursement(ERS_Reimbursement reimb){
        String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setDouble(1, Double.parseDouble(reimb.getReimb_amount().toString()));
            ps.setInt(2, reimb.getReimb_submitted().getId());
            ps.setString(3, user.getUser_first_name());
            ps.setString(4, user.getUser_last_name());
            ps.setString(5,user.getUser_email());
            ps.setInt(6, 2);
            Integer success = ps.executeUpdate();
            if(success == 1){
                return true;
            }
        }catch (SQLException e){
            //todo get rid of stacktrace
            e.printStackTrace();
        }
        return false;
    }
}
