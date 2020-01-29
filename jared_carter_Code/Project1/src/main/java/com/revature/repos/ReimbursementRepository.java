package com.revature.repos;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {


    public Set<Reimbursement> findAllById(int id) {
        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM ers.ers_reimbursement WHERE reimb_author = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }

    @Override
    public void save(Reimbursement newObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO ers.ers_reimbursement VALUES (0, ?, CURRENT_TIMESTAMP, null, ?, null, ?,null, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newObj.getAmount());
            pstmt.setString(2, newObj.getDescription());
            pstmt.setInt(3, newObj.getAuthorById());
            pstmt.setInt(4, newObj.getReimbursementStatusId().getId());
            pstmt.setInt(5, newObj.getReimbursementTypeId().getId());


            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Reimbursement> findAll() {
        Set<Reimbursement> reimbursement = new HashSet<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_reimbursement";
            Statement stmt = conn.createStatement();

        }
    }


    @Override
    public boolean update(Reimbursement updatedObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "UPDATE ers.ers_reimbursement SET reimb_status_id = ? " +
                    "WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updatedObj.getReimbursementStatusId().getId());
            pstmt.setInt(2, updatedObj.getId());

            int rowsUpdated = pstmt.executeUpdate();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {

        Set<Reimbursement> reimbursement = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getString("reimb_amount"));
            temp.setTimeSubmitted(rs.getTimestamp("reimb_submitted").toString());
            temp.setAuthorById(rs.getInt("reimb_author"));
            temp.setDescription(rs.getString("reimb_description"));
            temp.setReimbursementStatusId(ReimbursementStatus.getReimbursementStatusById(rs.getInt("reimb_status_id")));
            temp.setReimbursementTypeId(ReimbursementType.getReimbursementTypeById(rs.getInt("reimb_type_id")));
            reimbursement.add(temp);
        }

        return reimbursement;

    }

    @Override
    public Optional<Reimbursement> findById(int id) {
        return Optional.empty();
    }

}
