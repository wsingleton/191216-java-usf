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
                String sql = "INSERT INTO ers_reimbursement (reimbId, amount, " +
                        "expenseDate, description, receipt, author," +
                        " statusId, typeId) VALUES (0, ?, ?, ?, ?, ?, 1, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimbId"});
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
                String sql = "INSERT INTO ers_reimbursement (reimbId, amount, " +
                        "expenseDate, description, author, statusId, typeId) " +
                        "VALUES (0, ?, ?, ?, ?, 1, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimbId"});
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
            String sql = "SELECT * FROM ers_reimbursement";
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

            String sql = "SELECT * FROM ers_reimbursement WHERE reimbId = ?";
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

            String sql = "UPDATE ers_reimbursement SET resolved = CURRENT_DATE, " +
                    "resolver = ?, statusId = ? WHERE reimbId = ?";
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setInt(1, updatedReimb.getResolverId());
            pstmt.setInt(2, updatedReimb.getStatus().getStatusId());
            pstmt.setInt(3, updatedReimb.getReimbId());

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

            String sql = "DELETE FROM ers_reimbursement WHERE reimbId = ?";
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

            String sql = "SELECT * FROM ers_reimbursement WHERE typeId = ?";
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

            String sql = "SELECT * FROM ers_reimbursement WHERE typeId = ?";
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

            String sql = "SELECT * FROM ers_reimbursement WHERE author = ?";
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
            temp.setReimbId(rs.getInt("reimbId"));
            temp.setAmount(rs.getDouble("amount"));
            temp.setExpenseDate(rs.getString("expenseDate"));
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
