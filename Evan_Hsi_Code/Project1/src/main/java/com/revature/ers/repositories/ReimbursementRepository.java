package com.revature.ers.repositories;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.Type;
import com.revature.ers.models.User;
import com.revature.ers.servlets.AuthServlet;
import com.revature.ers.utils.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.rowset.serial.SerialBlob;
import java.io.InputStream;
import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {
    private static final Logger LOG = LogManager.getLogger(ReimbursementRepository.class);

    @Override
    public void save(Reimbursement newObj, User user) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("DAO layer saving reimbursement");

            String sql = "INSERT INTO ERS_APP.ERS_REIMBURSEMENT " +
                    "VALUES (0, ?, null, null, ?, ?, ?, 0, 1, ?)";
            String[] keys = {"REIMB_ID", "REIMB_SUBMITTED"};
            PreparedStatement pstmt = conn.prepareStatement(sql, keys);
            pstmt.setDouble(1, newObj.getAmount());
            pstmt.setString(2, newObj.getDescription());
            if(newObj.getReceipt() != null) {
                Blob bloblaw = new SerialBlob(newObj.getReceipt().getBytes());
                InputStream in = bloblaw.getBinaryStream();
                pstmt.setBinaryStream(3, in, bloblaw.length());
            }
            else pstmt.setBinaryStream(3, null);
            pstmt.setInt(4, newObj.getSubmitId());
            pstmt.setInt(5, newObj.getType().getId());

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()) {
                    newObj.setId(rs.getInt(1));
                    newObj.setSubmitTime(rs.getTimestamp(2).toLocalDateTime());
                }
            }
        } catch(SQLException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace(); }
    }

    @Override
    public Set<Reimbursement> findAll(User user) {

        LOG.info("DAO layer get all reimbursements");

        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection(user.getRole())) {

            String sql = "SELECT * FROM ERS_APP.ERS_REIMBURSEMENT";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace();
        }

        return reimbursements;

    }

    public Set<Reimbursement> getAllBut(int id, User user) {

        LOG.info("DAO layer get all reimbursements but current user's, where user id = {}", id);

        Set<Reimbursement> reimbursements = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection(user.getRole())) {

            String sql = "SELECT * FROM ERS_APP.ERS_REIMBURSEMENT WHERE NOT REIMB_AUTHOR = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace();
        }
        return reimbursements;
    }

    @Override
    public Optional<Reimbursement> findById(int id, User user) {

        LOG.info("DAO layer find Reimbursement by ID");

        Optional<Reimbursement> _reimb = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection(user.getRole())) {

            String sql = "SELECT * FROM ERS_APP.ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            _reimb = mapResultSet(rs).stream().findFirst();

        } catch (SQLException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace();
        }
        return _reimb;
    }

    @Override
    public boolean update(Reimbursement updatedObj, User user) {

        LOG.info("DAO layer update reimbursement");
        boolean updateSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection(user.getRole())) {
            String sql = "UPDATE ERS_APP.ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ?" +
                    " WHERE REIMB_ID = ? AND NOT REIMB_AUTHOR = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updatedObj.getStatus().getId());
            pstmt.setInt(2, updatedObj.getId());
            pstmt.setInt(3, user.getId());
            updateSuccessful = pstmt.execute();
        } catch (SQLException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace(); }
        return updateSuccessful;
    }

    @Override
    public boolean deleteById(int id, User user) {
        return false;
    }

    public Set<Reimbursement> findByAuthorId(int id, User user) {

        LOG.info("DAO layer find reimbursements by author id");
        Set<Reimbursement> reimbursements = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection(user.getRole())) {
            String sql = "SELECT * FROM ERS_APP.ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);
        } catch (SQLException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace(); }
        return reimbursements;
    }

    public Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {
        Set<Reimbursement> reimbursements = new HashSet<>();
        while(rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(rs.getInt("REIMB_ID"));
            temp.setSubmitId(rs.getInt("REIMB_AUTHOR"));
            temp.setSubmitTime(rs.getTimestamp("REIMB_SUBMITTED").toLocalDateTime());
            temp.setResolveId(rs.getInt("REIMB_RESOLVER"));
            if(rs.getTimestamp("REIMB_RESOLVED") != null) {
                temp.setResolveTime(rs.getTimestamp("REIMB_RESOLVED").toLocalDateTime());
            } else temp.setResolveTime(null);
            temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
            temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
            if(rs.getBlob("REIMB_RECEIPT") != null) {
                temp.setReceipt(new String (new SerialBlob(rs.getBlob("REIMB_RECEIPT"))
                        .getBytes(1, (int) rs.getBlob("REIMB_RECEIPT").length())));
            } else temp.setReceipt(null);
            temp.setType(Type.getById(rs.getInt("REIMB_TYPE_ID")));
            temp.setStatus(Status.getById(rs.getInt("REIMB_STATUS_ID")));
            reimbursements.add(temp);
        }
        return reimbursements;
    }
}
