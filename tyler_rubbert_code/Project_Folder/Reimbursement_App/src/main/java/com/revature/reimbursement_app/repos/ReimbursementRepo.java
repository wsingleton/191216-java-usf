package com.revature.reimbursement_app.repos;

import com.revature.reimbursement_app.models.Reimbursement;
import com.revature.reimbursement_app.models.ReimbursementStatus;
import com.revature.reimbursement_app.models.ReimbursementType;
import com.revature.reimbursement_app.models.User;
import com.revature.reimbursement_app.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Date;

public class ReimbursementRepo implements CrudRepository<Reimbursement> {

    public Set<Reimbursement> findReimbursementsByAuthorId(int id) {

        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;

    }

    public Set<Reimbursement> findReimbursementsByStatus(ReimbursementStatus status) {

        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, status.getId());

            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;

    }

    @Override
    public void save(Reimbursement newObj) {

        Date date = new Date();

        long time = date.getTime();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_author, " +
                    "reimb_description, reimb_status_id, reimb_type_id) VALUES (0, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimb_id"});
            pstmt.setDouble(1, newObj.getAmount());
            pstmt.setTimestamp(2, new Timestamp(time));
            pstmt.setInt(3, newObj.getAuthorId());
            pstmt.setString(4, newObj.getDescription());
            pstmt.setInt(5, newObj.getStatus().getId());
            pstmt.setInt(6, newObj.getType().getId());

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

        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;

    }

    @Override
    public Optional<Reimbursement> findById(int id) {

        Optional<Reimbursement> reimbursement = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            reimbursement = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursement;

    }

    @Override
    public boolean update(Reimbursement updatedObj) {

        boolean updateSuccessful = false;

        Date date = new Date();

        long time = date.getTime();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_description = ?, " +
                    "reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, new Timestamp(time));
            pstmt.setString(2, updatedObj.getDescription());
            pstmt.setInt(3, updatedObj.getResolverId());
            pstmt.setInt(4, updatedObj.getStatus().getId());
            pstmt.setInt(5, updatedObj.getId());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateSuccessful;

    }

    @Override
    public boolean deleteById(int id) {

        boolean deleteSuccesful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                deleteSuccesful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleteSuccesful;

    }

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {

        Set<Reimbursement> reimbursements = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getDouble("reimb_amount"));
            temp.setTimeSubmitted(rs.getString("reimb_submitted"));
            temp.setTimeResolved(rs.getString("reimb_resolved"));
            temp.setDescription(rs.getString("reimb_description"));
            temp.setReceipt(rs.getBinaryStream("reimb_receipt"));
            temp.setAuthorId(rs.getInt("reimb_author"));
            temp.setResolverId(rs.getInt("reimb_resolver"));
            temp.setStatus(ReimbursementStatus.getById(rs.getInt("reimb_status_id")));
            temp.setType(ReimbursementType.getById(rs.getInt("reimb_type_id")));
            reimbursements.add(temp);
        }

        return reimbursements;

    }

}
