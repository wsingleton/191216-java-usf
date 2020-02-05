package com.revature.repos;

import com.revature.models.Reimburstment;
import com.revature.models.Status;
import com.revature.utils.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReimburstRepository implements CrudRepository<Reimburstment> {

    public Set<Reimburstment> findByStatus(int id){
        Set<Reimburstment> reimb = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_reimburstment WHERE reimb_status_id = ?";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimb = mapResultSet(rs);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return reimb;
    }

    public Set<Reimburstment> findByType(int id){
        Set<Reimburstment> reimb = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_reimburstment WHERE reimb_type_id = ?";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimb = mapResultSet(rs);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return reimb;
    }

    public Set findAllByAuthor(Integer id) {

        Set<Reimburstment> reimbs = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_reimburstment WHERE reimb_author = ?";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimbs = mapResultSet(rs);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return reimbs;
    }

    @Override
    public void save(Reimburstment newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO ers.ers_reimburstment VALUES(0,?,CURRENT_TIMESTAMP,null,?,?,null,3,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimb_id"});
            pstmt.setDouble(1, newObj.getAmount());
            pstmt.setString(2, newObj.getDescription());
            pstmt.setInt(3, newObj.getAuthor());
            pstmt.setInt(4, newObj.getType());

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setId(rs.getInt(1));


                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public Set<Reimburstment> findAll() {

        Set<Reimburstment> reimbs = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_reimburstment";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reimbs = mapResultSet(rs);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return reimbs;
    }

    @Override
    public Optional<Reimburstment> findById(int id) {
        return Optional.empty();
    }

    public Set<Reimburstment> findByALLId(int id) {

            Set<Reimburstment> reimbs = new HashSet<>();
            try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
                String sql = "SELECT * FROM ers.ers_reimburstment WHERE reimb_author = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                reimbs = mapResultSet(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return reimbs;

    }

    @Override
    public boolean update(Reimburstment updateObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "UPDATE ers.ers_reimburstment SET reimb_status_id = ? " +
                    "WHERE reimb_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updateObj.getStatus().getId());
            pstmt.setInt(2, updateObj.getId());
            int rowsUpdated = pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private Set<Reimburstment> mapResultSet(ResultSet rs) throws SQLException{
        Set<Reimburstment> reimbs = new HashSet<>();
        while(rs.next()){
            Reimburstment temp = new Reimburstment();
            temp.setId(rs.getInt("reimb_id"));
            temp.setAmount(rs.getDouble("reimb_amount"));
            temp.setSubmitted(rs.getDate("reimb_submitted"));
            temp.setResolved(rs.getDate("reimb_resolved"));
            temp.setDescription(rs.getString("reimb_description"));
            temp.setAuthor(rs.getInt("reimb_author"));
            temp.setResolver(rs.getInt("reimb_resolver"));
            temp.setStatus(Status.getStatusbyId(rs.getInt("reimb_status_id")));
            temp.setType(rs.getInt("reimb_type_id"));
            reimbs.add(temp);
        }
        return reimbs;
    }
}
