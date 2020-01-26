package com.revature.mockERS.repositories;

import com.revature.mockERS.dto.ReimbursementOut;
import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.models.ERS_Reimbursement_Status;
import com.revature.mockERS.models.ERS_Reimbursement_Type;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.util.UserSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

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

    public ArrayList<ReimbursementOut> getAllUnprocessedReimbs(){
        ArrayList<ReimbursementOut> reimbs = new ArrayList<>();
        ReimbursementOut ro = new ReimbursementOut();
        String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1 OR reimb_status_id = 2";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Integer id = rs.getInt("reimb_id");
                String desc = rs.getString("reimb_description");
                Integer type = rs.getInt("reimb_type_id");
                Integer status = rs.getInt("reimb_status_id");
                Timestamp received = rs.getTimestamp("reimb_submitted");
                Timestamp completed = rs.getTimestamp("reimb_resolved");
                ro.setId(id);
                if(desc != null) {
                    ro.setDescription(desc);
                }else{
                    ro.setDescription("No description given.");
                }
                ERS_Reimbursement_Type typeEnum = ERS_Reimbursement_Type.getTypeById(type);
                ro.setType(typeEnum.getType());
                ERS_Reimbursement_Status statusEnum = ERS_Reimbursement_Status.getStatusById(status);
                ro.setStatus(statusEnum.getStatus());
                ro.setReceived(received);
                ro.setCompleted(completed);
                Boolean bool = reimbs.add(ro);
                if(reimbs.contains(ro)){
                    System.out.println("Repository RO: "+ bool);
                }
            }
            for(int i = 0; i < reimbs.size(); i++){
                System.out.println("Repository 2: ");
            }
            return reimbs;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
