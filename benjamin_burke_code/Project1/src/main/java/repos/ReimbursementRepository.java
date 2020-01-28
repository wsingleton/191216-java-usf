package repos;

import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Status;
import com.revature.project1.models.Type;
import com.revature.project1.util.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimbursementRepository implements CrudRepository<Reimbursement> {
    @Override
    public void save(Reimbursement reimb) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            if (reimb.getReceipt() !=null) {
                String sql = "insert into ers_reimbursement() VALUES ()";
                PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"reimb_id"});
                pstmt.setDouble(1, reimb.getAmount());
                //made it change to set date?
                pstmt.setString(2, reimb.getSubmitted());
                pstmt.setString(3, reimb.getDescription());
                pstmt.setInt(4, reimb.getAuthorId());
                pstmt.setInt(5, reimb.getStatus());
                pstmt.setInt(6, reimb.getType());
            }
        }
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
            temp.setStatus(Status.getById(rs.getInt("statusId")));
            temp.setType(Type.getTypeById(rs.getInt("typeId")));
            reimbs.add(temp);
        }

        return reimbs;

    }



    @Override
    public Optional<Reimbursement> findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(Reimbursement updatedObj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
