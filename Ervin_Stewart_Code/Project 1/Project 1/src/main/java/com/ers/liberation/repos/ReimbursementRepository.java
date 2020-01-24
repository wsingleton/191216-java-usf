package com.ers.liberation.repos;

import com.ers.liberation.models.*;
import com.ers.liberation.models.Reimbursement;
import com.ers.liberation.models.Reimbursement;
import com.ers.liberation.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {

    public Set<Reimbursement> findReimbByStatus(ReimbursementStatus reimbursementStatus) {

        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reimbursementStatus.getId());

            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;

    }

    public Set<Reimbursement> findReimbByType(ReimbursementType reimbursementType) {

        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_type_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reimbursementType.getId());

            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;

    }

    public Set<Reimbursement> findReimbursementById(Integer id) {

        Set<Reimbursement> reimbursements = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM ers_reimbursement WHERE ers_users_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;

    }


//    public Set<Reimbursement> findUserByCredentials(Integer diglong, String password) {
//
//        Optional<Reimbursement> user = Optional.empty();
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//
//            String sql = "SELECT * FROM app_user WHERE username = ? AND password = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, username);
//            pstmt.setString(2, password);
//
//            ResultSet rs = pstmt.executeQuery();
//            user = mapResultSet(rs).stream().findFirst();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return user;
//
//    }

    @Override
    public void save(Reimbursement newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO ers_reimbursement VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimb_id"});
            pstmt.setDouble(1, newObj.getUsername());
            pstmt.setTimestamp(2, newObj.getPassword());
            pstmt.setTimestamp(3, newObj.getRole().getId());
            pstmt.setString(4, newObj.getFirstName());
            pstmt.setBlob(5, newObj.getLastName());
            pstmt.setInt(6, newObj.getRole().getId());
            pstmt.setInt(7, newObj.getRole().getId());
            pstmt.setInt(8, newObj.getRole().getId());
            pstmt.setInt(9, newObj.getRole().getId());
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

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM ers_reimbursement";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimbursements = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;

    }

    @Override
    public Optional<Reimbursement> findById(Integer id) {

        return null;
    }

    @Override
    public Boolean update(Reimbursement updatedObj) {

        boolean updateSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, updatedObj.getResolved());
            pstmt.setInt(2, updatedObj.getResolverId());
            pstmt.setInt(3, updatedObj.getStatus());

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
    public Boolean deleteById(Integer id) {

        boolean deleteSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "DELETE FROM ers_reimbursement WHERE ers_users_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                deleteSuccessful = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleteSuccessful;

    }

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {

        Set<Reimbursement> reimbursements = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setReimbId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getDouble("reimb_amount"));
            temp.setSubmittedDate(rs.getTimestamp("reimb_submitted"));
            temp.setResolvedDate(rs.getTimestamp("reimb_resolved"));
            temp.setDescription(rs.getString("reimb_description"));
            temp.setReceipt(rs.getBinaryStream("reimb_receipt")));
            temp.setAuthorId(rs.getInt("reimb_author"));
            temp.setResolverId(rs.getInt("reimb_resolver"));
            temp.setStatus(rs.getInt("reimb_status_id"));
            temp.setType(rs.getInt("reimb_type_id"));
            reimbursements.add(temp);
        }

        return reimbursements;

    }
}
