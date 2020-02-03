package com.revature.repos;

import com.revature.models.Category;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbRepository implements CrudRepository<Reimbursement> {

    private Set<Reimbursement> mapResults(ResultSet results) throws SQLException {
        Set<Reimbursement> reimb = new HashSet<>();
        while (results.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(results.getInt("reimb_id"));
            temp.setAuthId(results.getInt("reimb_amount"));
            temp.setResId(results.getInt("reimb_resolver"));
            temp.setTimeSubmitted(results.getString("reimb_submitted"));
            temp.setTimeResolved(results.getString("reimb_resolved"));
            temp.setDescription(results.getString("reimb_description"));
            temp.setReceipt(results.getString("reimb_receipt"));
            temp.setAmount(results.getString("reimb_amount"));
            temp.setStatusId(Status.getById(results.getInt("reimb_status_id")));
            temp.setCategoryId(Category.getById(results.getInt("reimb_type_id")));

            reimb.add(temp);
        } return reimb;
    }

    public Set<Reimbursement> findByStatus(int statusId) {
        Set<Reimbursement> reimb = new HashSet<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM xnd_inc.ers_reimbursement WHERE reimb_status_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, statusId);

            ResultSet results = pstmt.executeQuery();
            reimb = mapResults(results);
        } catch (SQLException e) {
            e.printStackTrace();
        } return reimb;
    }


    @Override
    public void save(Reimbursement reimb) {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String sql = "INSERT INTO xnd_inc.ers_reimbursement VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"ers_reimbursement"});
            pstmt.setString(1, reimb.getAmount());
            pstmt.setString(2, reimb.getTimeResolved());
            pstmt.setString(3, reimb.getTimeSubmitted());
            pstmt.setString(4, reimb.getDescription());
            pstmt.setString(5, reimb.getReceipt());
            pstmt.setInt(6, reimb.getAuthId());
            pstmt.setInt(7, reimb.getResId());
            pstmt.setInt(8, reimb.getStatusId().getId());
            pstmt.setInt(9, reimb.getCategoryId().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Reimbursement> findAll() {
        return null;
    }

    @Override
    public Optional<Reimbursement> findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Reimbursement updatedObj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
