package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.util.ConnectionFactory;

import java.sql.*;
import java.util.*;

public class UserRepository implements CrudRepository<User> {



    public Set<User> findUsersByRole(Role role){
        return null;
    }

    @Override
    public void save(User newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO rbs_app.users VALUES (0, ?, ?, ?, ?, ?)";
            //to get generated id, has to be a string array(because you can potentially have multiple generated ids, column that will have generated id
            PreparedStatement pstmt = conn.prepareStatement(sql,new String[] {"user_id"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstName());
            pstmt.setString(4, newObj.getLastName());


            //returns the number of rows that were affected
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();

                while (rs.next()){
                    newObj.setId(rs.getInt(1));
                }

            }

        } catch( SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> findAll() {

        Set<User> users = new HashSet<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM rbs_app.users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    public Optional<User> findUserByUsername(String username){
        Optional<User> _user = Optional.empty();


        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM rbs_app.users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);

            if(!set.isEmpty()) _user = set.stream().findFirst();

        }catch(SQLException e){

        }

        return _user;
    }

    public Optional<User> findUserByCredentials(String username, String password){
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM rbs_app.users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            Set<User> set = mapResultSet(rs);

            if(!set.isEmpty()){
                _user = set.stream().findFirst();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return _user;
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM rbs_app.users WHERE ? = user_id";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();

            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();
            else System.out.println("User does not exist");

        }catch(SQLException e){
            e.printStackTrace();;
        }

        return _user;
    }

    @Override
    public Boolean update(User updatedObj) {
      return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//            String sql = "DELETE * FROM rbs_app.users WHERE ? = user_id";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, Integer.toString(id));
//            ResultSet rs = pstmt.executeQuery();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("user_id"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setRole(Role.getRoleById(rs.getInt("role_id")));
            users.add(temp);
        }

        return users;
    }
}
