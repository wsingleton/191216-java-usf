package com.revature.repos;

import com.revature.models.Reimburstment;
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
            String sql = "INSERT INTO ers.ers_reimburstment VALUES((SELECT MAX(reimb_id)+1 FROM ers.ers_reimburstment),?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"reimb_id"});
            pstmt.setDouble(1, newObj.getAmount());
            pstmt.setDate(2, (Date) newObj.getSubmitted()); // might need to use string?
            pstmt.setDate(3, (Date) newObj.getResolved());
            pstmt.setString(4, newObj.getDescription());
            pstmt.setInt(5, newObj.getAuthor());
            pstmt.setInt(6, newObj.getResolver());
            pstmt.setInt(7, newObj.getStatus());
            pstmt.setInt(8, newObj.getType());

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setId(rs.getInt(1));
                    newObj.setResolver(0);
                    newObj.setResolved(new Date(0));
                    newObj.setType(3);

                }
            }
        }
        catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public Set findAll() {

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

        Optional<Reimburstment> _reimb = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_reimburstment WHERE reimb_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Set<Reimburstment> set = mapResultSet(rs);
            if(!set.isEmpty()) _reimb = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return _reimb;
    }

    @Override
    public boolean update(Reimburstment updateObj) {
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
            temp.setStatus(rs.getInt("reimb_status_id"));
            temp.setType(rs.getInt("reimb_type_id"));
            reimbs.add(temp);
        }
        return reimbs;
    }
}
