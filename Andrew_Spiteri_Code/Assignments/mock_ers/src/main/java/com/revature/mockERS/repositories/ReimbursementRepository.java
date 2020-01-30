package com.revature.mockERS.repositories;

import com.revature.mockERS.dto.ReimbursementIn;
import com.revature.mockERS.dto.ReimbursementOut;
import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.models.ERS_Reimbursement_Status;
import com.revature.mockERS.models.ERS_Reimbursement_Type;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.util.UserSession;

import java.sql.*;
import java.util.*;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.revature.mockERS.util.ConnectionFactory.getCon;

public class ReimbursementRepository {
    private static final Logger LOGGER = LogManager.getLogger(ReimbursementRepository.class.getName());

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
            LOGGER.debug(e.getMessage());
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
                    LOGGER.info("Repository RO: "+ bool);
                }
            }
            for(int i = 0; i < reimbs.size(); i++){
                LOGGER.info("Repository 2: ");
            }
            return reimbs;
        }catch (SQLException e){
            LOGGER.debug(e.getMessage());
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
            LOGGER.debug(e.getMessage());
            e.printStackTrace();
        }
        //TODO replace null with an Optional
        return null;
    }

    public Boolean updateReimbStatus(ERS_Reimbursement ers){
        Boolean outcome = false;
        System.out.println("res value: "+ ers.getReimbId());
        //String sql = "{CALL ers_app.update_reimbs(?)}";
        String sql = "UPDATE ers_reimbursement SET reimb_status_id = ? WHERE reimb_id = ?";
        try {
//            CallableStatement cs = getCon().prepareCall(sql);
//            cs.setInt(1, ers.getStatus().getId());
//            outcome = cs.execute();
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, ers.getStatus().getId());
            ps.setInt(2, ers.getReimbId());
            Integer result = ps.executeUpdate();
            if(ers.getStatus().getId().equals(3)  || ers.getStatus().getId().equals(4)){
                Date date = new Date();
                sql = "UPDATE ers_reimbursement SET reimb_resolved = ? WHERE reimb_id = ?";
                ps = getCon().prepareStatement(sql);
                ps.setTimestamp(1, new Timestamp(date.getTime()));
                ps.setInt(2, ers.getReimbId());
                result += ps.executeUpdate();
                if(result == 2){
                    return true;
                }
            }
            if(result == 1){
                return true;
            }
        }catch (SQLException e){
            LOGGER.debug(e.getMessage());
            e.printStackTrace();
        }
        return outcome;
    }
}
