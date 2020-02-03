package com.revature.project1.repos;

import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Status;
import com.revature.project1.models.Type;
import com.revature.project1.util.ConnectionFactory;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {



    @Override
    public void save(Reimbursement newObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO ers_reimbursement VALUES (0, ?, CURRENT_TIMESTAMP, null, ?, null, ?,null, ?, ?)";
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

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {


            String sql = "{CALL get_all_reimb(?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet)  cstmt.getObject(1);
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

    public Set<Reimbursement> findAllById(int id) {

        Set<Reimbursement> reimb = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";


            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);


            ResultSet rs = pstmt.executeQuery();
            reimb = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimb;
    }

    @Override
    public boolean update(Reimbursement updatedObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "UPDATE ers_reimbursement SET reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = CURRENT_TIMESTAMP " +
                    "WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,updatedObj.getStatusId().getId());
            pstmt.setInt(2, updatedObj.getResId());
            pstmt.setInt(3, updatedObj.getId());

            int rowsUpdated = pstmt.executeUpdate();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        boolean deleteSuccessful = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "DELETE FROM app_user WHERE user_id = ?";
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

        Set<Reimbursement> reimbursement = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getString("reimb_amount"));
            temp.setAuthId(rs.getInt("reimb_author"));
            temp.setDesc(rs.getString("reimb_description"));
            temp.setStatusId(Status.getById(rs.getInt("reimb_status_id")));
            temp.setTypeId(Type.getById(rs.getInt("reimb_type_id")));
            temp.setSubTime(rs.getString("reimb_submitted"));
            temp.setResTimed(rs.getString("reimb_resolved"));
            temp.setResId(rs.getInt("reimb_resolver"));
            reimbursement.add(temp);
        }

        return reimbursement;

    }
}
