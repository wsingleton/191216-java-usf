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

    public List<ReimbursementOut> getAllUnprocessedReimbs(){
        List<ReimbursementOut> reimbs = new ArrayList<>();
        String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1 OR reimb_status_id = 2";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Integer id, type, status;
            Double amount;
            String desc;
            Timestamp received, completed;
            ERS_Reimbursement_Type typeEnum;
            ERS_Reimbursement_Status statusEnum;
            Boolean bool;

            while (rs.next()){
                id = rs.getInt("reimb_id");
                desc = rs.getString("reimb_description");
                amount = rs.getDouble("reimb_amount");
                type = rs.getInt("reimb_type_id");
                status = rs.getInt("reimb_status_id");
                received = rs.getTimestamp("reimb_submitted");
                completed = rs.getTimestamp("reimb_resolved");
                ReimbursementOut ro = new ReimbursementOut();
                ro.setId(id);
                if(desc != null) {
                    ro.setDescription(desc);
                }else{
                    ro.setDescription("No description given.");
                }
                ro.setAmount(amount);
                typeEnum = ERS_Reimbursement_Type.getTypeById(type);
                ro.setType(typeEnum.getType());
                statusEnum = ERS_Reimbursement_Status.getStatusById(status);
                ro.setStatus(statusEnum.getStatus());
                ro.setReceived(received);
                ro.setCompleted(completed);
                bool = reimbs.add(ro);
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

    public Set<ReimbursementOut> getReimbursementByUser(Integer id){

        Set<ReimbursementOut> reimbs = new HashSet<>();
        String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Integer reimb_id, type, status;
            Double amount;
            String desc;
            Timestamp received, completed;
            ERS_Reimbursement_Type typeEnum;
            ERS_Reimbursement_Status statusEnum;
            Boolean bool;

            while (rs.next()){
                reimb_id = rs.getInt("reimb_id");
                desc = rs.getString("reimb_description");
                amount = rs.getDouble("reimb_amount");
                type = rs.getInt("reimb_type_id");
                status = rs.getInt("reimb_status_id");
                received = rs.getTimestamp("reimb_submitted");
                completed = rs.getTimestamp("reimb_resolved");
                ReimbursementOut ro = new ReimbursementOut();
                ro.setId(reimb_id);
                if(desc != null) {
                    ro.setDescription(desc);
                }else{
                    ro.setDescription("No description given.");
                }
                ro.setAmount(amount);
                typeEnum = ERS_Reimbursement_Type.getTypeById(type);
                ro.setType(typeEnum.getType());
                statusEnum = ERS_Reimbursement_Status.getStatusById(status);
                ro.setStatus(statusEnum.getStatus());
                ro.setReceived(received);
                ro.setCompleted(completed);
                bool = reimbs.add(ro);
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
        //TODO replace null with an Optional
        return null;
    }
}
