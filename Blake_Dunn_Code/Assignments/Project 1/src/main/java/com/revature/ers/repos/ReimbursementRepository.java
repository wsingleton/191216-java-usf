package com.revature.ers.repos;

import com.revature.ers.models.*;
import com.revature.ers.util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {

    private static final Logger LOG = LogManager.getLogger(ReimbursementRepository.class);

    @Override
    public Reimbursement save(Reimbursement newReimb) {
            LOG.info("Establishing connection with database.");
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

                LOG.info("Connection made. Saving new reimbursement request made by, {}", newReimb.getAuthorId());
                String sql = "INSERT INTO ers_reimbursement (reimbId, amount, " +
                        "description, author, statusId, typeId) " +
                        "VALUES (0, ?, ?, ?, 1, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimbId"});
                pstmt.setDouble (1, newReimb.getAmount());
                pstmt.setString(2, newReimb.getDescription());
                pstmt.setInt(3, newReimb.getAuthorId());
                pstmt.setInt(4, newReimb.getType().getTypeId());

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted != 0) {
                    LOG.info("New reimbursement entry was successfully inserted!");
                    ResultSet rs = pstmt.getGeneratedKeys();

                    while(rs.next()) {
                        newReimb.setReimbId(rs.getInt(1));
                    }
                }

        } catch(SQLIntegrityConstraintViolationException e) {
            LOG.warn(e.getMessage());
        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        return newReimb;

    }

    @Override
    public Set<Reimbursement> findAll() {

        Set<Reimbursement> reimbs = new HashSet<>();

        LOG.info("Establishing connection with database.");
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            LOG.info("Retrieving all pending requests.");
            String sql = "SELECT * FROM ers_reimbursement WHERE statusId = 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimbs = mapResultSet(rs);
        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        LOG.info("Retrieval was a success!");
        return reimbs;
    }

    @Override
    public Optional<Reimbursement> findById(Integer id) {

        Optional<Reimbursement> _reimb = Optional.empty();

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Retrieving reimbursement by id, {}", id);
            String sql = "SELECT * FROM ers_reimbursement WHERE reimbId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Set<Reimbursement> set = mapResultSet(rs);
            if (!set.isEmpty()) _reimb = set.stream().findFirst();

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("Reimbursement retrieved!");
        return _reimb;
    }

    @Override
    public Boolean update(Reimbursement updatedReimb) {

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "{call update_reimb(?, ?, ?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, updatedReimb.getResolverId());
            cstmt.setInt(2, updatedReimb.getStatus().getStatusId());
            cstmt.setInt(3, updatedReimb.getReimbId());

            int rowsInserted = cstmt.executeUpdate();

            if (rowsInserted == 0) return false;

        } catch(SQLIntegrityConstraintViolationException e) {
            LOG.warn(e.getMessage());
        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("Reimbursement has been updated!");
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Deleting reimbursement with id, {}", id);
            String sql = "DELETE FROM ers_reimbursement WHERE reimbId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted == 0){
                return false;
            }
        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("Reimbursement successfully deleted!");
        return true;
    }

    public Set<Reimbursement> findReimbByType(int typeId) {

        Set<Reimbursement> reimbs = new HashSet<>();

        LOG.info("Establishing connection with database.");
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Retrieving reimbursements by, {}", ReimbursementType.getTypeById(typeId));
            String sql = "SELECT * FROM ers_reimbursement WHERE typeId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, typeId);

            ResultSet rs = pstmt.executeQuery();
            reimbs = mapResultSet(rs);

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("Reimbursements retrieved!");
        return reimbs;
    }

    public Set<Reimbursement> findReimbByStatus(int statusId) {

        Set<Reimbursement> reimbs = new HashSet<>();

        LOG.info("Establishing connection with database.");
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Retrieving requests by, {}", ReimbursementStatus.getStatusById(statusId));
            String sql = "SELECT * FROM ers_reimbursement WHERE statusId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, statusId);

            ResultSet rs = pstmt.executeQuery();
            reimbs = mapResultSet(rs);

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("Reimbursements retrieved by status, {}", ReimbursementStatus.getStatusById(statusId));
        return reimbs;
    }

    public Set<Reimbursement> findByUserId(Integer id) {

        Set<Reimbursement> reimb = new HashSet<>();

        LOG.info("Establishing connection with database.");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            LOG.info("Retrieving requests by user id, {}", id);
            String sql = "SELECT * FROM ers_reimbursement WHERE author = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            reimb = mapResultSet(pstmt.executeQuery());

        }catch (SQLException e) {
            LOG.warn(e.getMessage());
        }

        return reimb;
    }

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {

        Set<Reimbursement> reimbs = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setReimbId(rs.getInt("reimbId"));
            temp.setAmount(rs.getDouble("amount"));
            temp.setSubmitted(rs.getString("submitted"));
            temp.setDescription(rs.getString("description"));
            temp.setReceipt(rs.getBinaryStream("receipt"));
            temp.setAuthorId(rs.getInt("author"));
            temp.setStatus(ReimbursementStatus.getStatusById(rs.getInt("statusId")));
            temp.setType(ReimbursementType.getTypeById(rs.getInt("typeId")));
            reimbs.add(temp);
        }

        return reimbs;
    }
}
