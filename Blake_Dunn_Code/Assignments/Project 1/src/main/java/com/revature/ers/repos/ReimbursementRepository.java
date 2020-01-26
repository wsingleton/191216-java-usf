package com.revature.ers.repos;

import com.revature.ers.models.*;
import com.revature.ers.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {

    @Override
    public Reimbursement save(Reimbursement newReimb) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            if (newReimb.getReceipt() != null) {
                String sql = "INSERT INTO ersadmin.ers_reimbursement (reimb_id, reimb_amount, " +
                        "expense_date, reimb_description, reimb_receipt, reimb_author," +
                        " reimb_status_id, reimb_type_id) VALUES (0, ?, ?, ?, ?, ?, 1, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimb_id"});
                pstmt.setDouble (1, newReimb.getAmount());
                pstmt.setString(2, newReimb.getExpenseDate());
                pstmt.setString(3, newReimb.getDescription());
                pstmt.setBlob(4, newReimb.getReceipt());
                pstmt.setInt(5, newReimb.getAuthorId());
                pstmt.setInt(6, newReimb.getType().getTypeId());

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted != 0) {
                    ResultSet rs = pstmt.getGeneratedKeys();

                    while(rs.next()) {
                        newReimb.setReimbId(rs.getInt(1));
                    }
                }
            }else {
                String sql = "INSERT INTO ersadmin.ers_reimbursement (reimb_id, reimb_amount, " +
                        "expense_date, reimb_description, reimb_author, reimb_status_id, reimb_type_id) " +
                        "VALUES (0, ?, ?, ?, ?, 1, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimb_id"});
                pstmt.setDouble (1, newReimb.getAmount());
                pstmt.setString(2, newReimb.getExpenseDate());
                pstmt.setString(3, newReimb.getDescription());
                pstmt.setInt(4, newReimb.getAuthorId());
                pstmt.setInt(5, newReimb.getType().getTypeId());

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted != 0) {
                    ResultSet rs = pstmt.getGeneratedKeys();

                    while(rs.next()) {
                        newReimb.setReimbId(rs.getInt(1));
                    }
                }
            }
        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return newReimb;

    }

    @Override
    public Set<Reimbursement> findAll() {

        Set<Reimbursement> reimbs = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM ersadmin.ers_reimbursement";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimbs = mapResultSet(rs);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbs;
    }

    @Override
    public Optional<Reimbursement> findById(Integer id) {

        Optional<Reimbursement> _reimb = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ersadmin.ers_reimbursement WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Set<Reimbursement> set = mapResultSet(rs);
            if (!set.isEmpty()) _reimb = set.stream().findFirst();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return _reimb;
    }

    @Override
    public Boolean update(Reimbursement updatedReimb) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE ersadmin.ers_reimbursement SET reimb_resolved = ?, " +
                    "reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setString (1, updatedReimb.getResolved());
            pstmt.setInt(2, updatedReimb.getResolverId());
            pstmt.setInt(3, updatedReimb.getStatus().getStatusId());
            pstmt.setInt(4, updatedReimb.getReimbId());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted == 0) return false;

        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "DELETE FROM ersadmin.ers_reimbursement WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted == 0){
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Set<Reimbursement> findReimbByType(int typeId) {

        Set<Reimbursement> reimbs = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ersadmin.ers_reimbursement WHERE reimb_type_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, typeId);

            ResultSet rs = pstmt.executeQuery();
            reimbs = mapResultSet(rs);

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbs;
    }

    public Set<Reimbursement> findReimbByStatus(int statusId) {

        Set<Reimbursement> reimbs = new HashSet<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ersadmin.ers_reimbursement WHERE reimb_type_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, statusId);

            ResultSet rs = pstmt.executeQuery();
            reimbs = mapResultSet(rs);

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbs;
    }

    public Set<Reimbursement> findByUserId(Integer id) {

        Set<Reimbursement> reimb = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ersadmin.ers_reimbursement WHERE author_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            reimb = mapResultSet(pstmt.executeQuery());

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return reimb;
    }

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {
        Set<Reimbursement> reimbs = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setReimbId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getDouble("reimb_amount"));
            temp.setExpenseDate(rs.getString("expense_date"));
            temp.setSubmitted(rs.getString("reimb_submitted"));
            temp.setDescription(rs.getString("reimb_description"));
            temp.setReceipt(rs.getBinaryStream("reimb_receipt"));
            temp.setAuthorId(rs.getInt("reimb_author"));
            temp.setStatus(ReimbursementStatus.getStatusById(rs.getInt("reim_status_id")));
            temp.setType(ReimbursementType.getTypeById(rs.getInt("reimb_type_id")));
        }

        return reimbs;
    }
}
