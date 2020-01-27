package com.revature.ers.repos;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {
    @Override
    public void save(Reimbursement reimb) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            if (reimb.getReceipt()!=null && reimb.getDesc()!=null) {
                String sql = "INSERT INTO proj_1_admin.ers_reimbursement (REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, reimb.getAmt());
                pstmt.setLong(2, reimb.getSubmitted());
                pstmt.setString(3,reimb.getDesc());
                pstmt.setBytes(4,reimb.getReceipt());
                pstmt.setInt(5, reimb.getAuthID());
                pstmt.setInt(6, reimb.getStatus());
                pstmt.setInt(7,reimb.getType());
                pstmt.executeUpdate();
            }
            else if (reimb.getReceipt()!=null) {
                String sql = "INSERT INTO proj_1_admin.ers_reimbursement (REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, reimb.getAmt());
                pstmt.setLong(2, reimb.getSubmitted());
                pstmt.setBytes(3,reimb.getReceipt());
                pstmt.setInt(4, reimb.getAuthID());
                pstmt.setInt(5, reimb.getStatus());
                pstmt.setInt(6,reimb.getType());
                pstmt.executeUpdate();
            }
            else if (reimb.getDesc()!=null) {
                String sql = "INSERT INTO proj_1_admin.ers_reimbursement (REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, reimb.getAmt());
                pstmt.setLong(2, reimb.getSubmitted());
                pstmt.setString(3,reimb.getDesc());
                pstmt.setInt(4, reimb.getAuthID());
                pstmt.setInt(5, reimb.getStatus());
                pstmt.setInt(6,reimb.getType());
                pstmt.executeUpdate();
            }
            else {
                String sql = "INSERT INTO proj_1_admin.ers_reimbursement (REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, reimb.getAmt());
                pstmt.setLong(2, reimb.getSubmitted());
                pstmt.setInt(3, reimb.getAuthID());
                pstmt.setInt(4, reimb.getStatus());
                pstmt.setInt(5,reimb.getType());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Reimbursement> findById(int id) {
        Optional<Reimbursement> reimb = Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "SELECT * FROM proj_1_admin.ers_reimbursement WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            reimb = mapResultSet(rs).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimb;
    }

    @Override
    public boolean update(Reimbursement reimb) {
//        boolean updateSuccessful = false;
////        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
////            String sql = "UPDATE proj_1_adamin.ers_users SET ers_username=?, ers_password=?, user_first_name=?, user_last_name=?, user_email=?, user_role_id=? " +
////                    "WHERE ers_users_id = ?";
////            PreparedStatement pstmt = conn.prepareStatement(sql);
////            pstmt.setString(1, user.getUsername());
////            pstmt.setString(2, user.getPassHash());
////            pstmt.setString(3, user.getFirst());
////            pstmt.setString(4, user.getLast());
////            pstmt.setString(5, user.getEmail());
////            pstmt.setInt(6, user.getRole());
////            pstmt.setInt(7, user.getUserID());
////            int rowsUpdated = pstmt.executeUpdate();
////            if (rowsUpdated > 0) {
////                updateSuccessful = true;
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return updateSuccessful;
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {

        Set<Reimbursement> reimbs = new HashSet<>();
        while (rs.next()) {
            Reimbursement tempReimb = new Reimbursement();
            tempReimb.setReimbID(rs.getInt("reimb_id"));
            tempReimb.setAmt(rs.getDouble("reimb_amount"));
            tempReimb.setSubmitted(rs.getLong("reimb_submitted"));
            tempReimb.setResolved(rs.getLong("reimb_resolved"));
            tempReimb.setDesc(rs.getString("reimb_description"));
            tempReimb.setReceipt(rs.getBytes("reimb_receipt"));
            tempReimb.setAuthID(rs.getInt("reimb_author"));
            tempReimb.setResID(rs.getInt("reimb_resolver"));
            tempReimb.setStatus(rs.getInt("reimb_status_id"));
            tempReimb.setType(rs.getInt("reimb_type_id"));
            reimbs.add(tempReimb);
        }
        return reimbs;
    }
}
