package com.revature.ers.repositories;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.Type;
import com.revature.ers.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {
    @Override
    public void save(Reimbursement newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO ERS_APP.ERS_REIMBURSEMENT " +
                    "VALUES (0, ?, 0, null, ?, ?, ?, ?, ?, ?";
            String[] keys = {"REIMB_ID", "REIMB_SUBMITTED"};
            PreparedStatement pstmt = conn.prepareStatement(sql, keys);
            pstmt.setDouble(1, newObj.getAmount());
            pstmt.setString(2, newObj.getDescription());
            pstmt.setBlob(3, newObj.getReceipt());
            pstmt.setInt(4, newObj.getSubmitId());
            pstmt.setInt(5, newObj.getResolveId());
            pstmt.setInt(6, newObj.getStatus().getId());
            pstmt.setInt(7, newObj.getType().getId());

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                    newObj.setSubmitTime(rs.getTimestamp(2));
                }
            }
        } catch(SQLException e) { e.printStackTrace(); }
    }

    @Override
    public Set<Reimbursement> findAll() {
        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ERS_APP.ERS_REIMBURSEMENT";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) { e.printStackTrace(); }

        return reimbursements;

    }

    @Override
    public Optional<Reimbursement> findById(int id) {
        Optional<Reimbursement> _reimb = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ERS_APP.ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            _reimb = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) { e.printStackTrace(); }
        return _reimb;
    }

    @Override
    public boolean update(Reimbursement updatedObj) {
        boolean updateSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ?" +
                    " WHERE REIMB_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updatedObj.getStatus().getId());
            pstmt.setInt(2, updatedObj.getId());
            updateSuccessful = pstmt.execute();
        } catch (SQLException e) { e.printStackTrace(); }
        return updateSuccessful;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    public Set<Reimbursement> findByAuthorId(int id) {
        Set<Reimbursement> reimbursements = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM ERS_APP.ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);
        } catch (SQLException e) { e.printStackTrace(); }
        return reimbursements;
    }

    public Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {
        Set<Reimbursement> reimbursements = new HashSet<>();
        while(rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(rs.getInt("REIMB_ID"));
            temp.setSubmitId(rs.getInt("REIMB_AUTHOR"));
            temp.setSubmitTime(rs.getTimestamp("REIMB_SUBMITTED"));
            temp.setResolveId(rs.getInt("REIMB_RESOLVER"));
            temp.setResolveTime(rs.getTimestamp("REIMB_RESOLVED"));
            temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
            temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
            temp.setReceipt(rs.getBlob("REIMB_RECEIPT"));
            temp.setType(Type.getById(rs.getInt("REIMB_TYPE_ID")));
            temp.setStatus(Status.getById(rs.getInt("REIMB_STATUS_ID")));
            reimbursements.add(temp);
        }
        return reimbursements;
    }
}
