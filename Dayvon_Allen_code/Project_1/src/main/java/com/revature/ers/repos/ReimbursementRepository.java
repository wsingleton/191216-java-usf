package com.revature.ers.repos;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.Type;
import com.revature.ers.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {
    @Override
    public void save(Reimbursement newObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO ers_project.ers_reimbursement VALUES (0, ?, CURRENT_TIMESTAMP, null, ?, null, ?,null, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newObj.getAmount());
            pstmt.setString(2, newObj.getDesc());
            pstmt.setInt(3, newObj.getAuthId());
            pstmt.setInt(4, newObj.getStatusId().getId());
            pstmt.setInt(5, newObj.getTypeId().getId());



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

        Set<Reimbursement> reimb = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM ers_project.ers_reimbursement";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimb = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimb;
    }

    @Override
    public Optional<Reimbursement> findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Reimbursement updatedObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE ers_project.ers_reimbursement SET reimb_status_id = (?), reimb_resolver_id = (?)  WHERE reimb_id = (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updatedObj.getStatusId().getId());
            pstmt.setInt(2, updatedObj.getResId());
            pstmt.setInt(3, updatedObj.getId());


            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {

        Set<Reimbursement> reimbursement = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getString("reimb_amount"));
            temp.setSubTime("reimb_submitted");
            temp.setAuthId(rs.getInt("reimb_author"));
            temp.setDesc(rs.getString("reimb_description"));
            temp.setStatusId(Status.getById(rs.getInt("reimb_status_id")));
            temp.setTypeId(Type.getById(rs.getInt("reimb_type_id")));
            reimbursement.add(temp);
        }

        return reimbursement;

    }
}
