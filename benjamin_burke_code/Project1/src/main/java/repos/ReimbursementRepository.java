package repos;

import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Status;
import com.revature.project1.models.Type;
import com.revature.project1.models.User;
import com.revature.project1.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {
    @Override
    public Reimbursement save(Reimbursement reimb) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){


                String sql = "insert into ers_reimbursement VALUES (0, ?, null ,null, ?, null, ?, null, 1, ?, CURRENT_TIMESTAMP)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, reimb.getAmount());
                pstmt.setString(2, reimb.getDescription());
                pstmt.setInt(3, reimb.getAuthorId());
                pstmt.setInt(4, reimb.getType().getTypeId());

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted !=0){
                    ResultSet rs = pstmt.getGeneratedKeys();

                    while(rs.next()){
                        reimb.setId(rs.getInt(1));
                    }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimb;
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

    private Set<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {
        Set<Reimbursement> reimbs = new HashSet<>();

        while (rs.next()) {
            Reimbursement temp = new Reimbursement();
            temp.setId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getDouble("reimb_amount"));
            temp.setDate(rs.getString("expense_date"));
            temp.setSubmitted(rs.getString("reimb_submitted"));
            temp.setDescription(rs.getString("reimb_description"));
            temp.setReceipt(rs.getBinaryStream("reimb_receipt"));
            temp.setAuthorId(rs.getInt("reimb_author"));
            //hmmmmmmm
            temp.setStatus(Status.getStatusById(rs.getInt("statusId")));
            temp.setType(Type.getTypeById(rs.getInt("typeId")));

        }

        return reimbs;

    }



    @Override
    public Optional<Reimbursement> findById(int id) {

        Optional<Reimbursement> _reimb = Optional.empty();


        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement WHERE remb_id = ?";
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


    public Set<Reimbursement> findByUserId(Integer id) {

        Set<Reimbursement> reimb = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            reimb = mapResultSet(pstmt.executeQuery());

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return reimb;
    }






    @Override
    public boolean update(Reimbursement updatedObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "UPDATE ers_reimbursement SET resolved = CURRENT_DATE, " +
                    "resolver = ?, statusId = ? WHERE reimbId = ?";
            PreparedStatement pstmt = conn.prepareCall(sql);
            pstmt.setInt(1, updatedObj.getResolverId());
            pstmt.setInt(2, updatedObj.getStatus().getStatusId());
            pstmt.setInt(3, updatedObj.getId());

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
    public boolean deleteById(int id) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
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
}
