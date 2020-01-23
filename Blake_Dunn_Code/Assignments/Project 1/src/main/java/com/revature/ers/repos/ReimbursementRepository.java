package com.revature.ers.repos;

import com.revature.ers.models.*;
import com.revature.ers.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {

    @Override
    public void save(Reimbursement newReimb) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO ersadmin.ers_reimbursement VALUES (0, ?, ?, ?, ?, ?, 1, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimb_id"});
            pstmt.setDouble (1, newReimb.getAmount());
            pstmt.setDate(2, (Date) newReimb.getExpenseDate());
            pstmt.setString(3, newReimb.getDescription());
            pstmt.setBinaryStream(4, newReimb.getReceipt());
            pstmt.setInt(5, newReimb.getAuthorId());
            pstmt.setInt(6, newReimb.getType().ordinal() + 1);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();

                while(rs.next()) {
                    newReimb.setReimbId(rs.getInt(1));
                }
            }
        } catch(SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }

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

            String sql = "SELECT * FROM ersadmin.ers_reimbursement WHERE author_id = ?";
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
            pstmt.setDate (1, (Date) updatedReimb.getResolved());
            pstmt.setInt(2, updatedReimb.getResolverId());
            pstmt.setInt(3, updatedReimb.getStatus().ordinal() + 1);
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

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {
        Set<Reimbursement> reimbs = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setReimbId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getDouble("reimb_amount"));
            temp.setExpenseDate(rs.getDate("expense_date"));
            temp.setSubmitted(rs.getDate("reimb_submitted"));
            temp.setDescription(rs.getString("reimb_description"));
            temp.setReceipt(rs.getBinaryStream("reimb_receipt"));
            temp.setAuthorId(rs.getInt("reimb_author"));
            temp.setStatus(ReimbursementStatus.getStatusById(rs.getInt("reim_status_id")));
            temp.setType(ReimbursementType.getTypeById(rs.getInt("reimb_type_id")));
        }

        return reimbs;
    }
}
