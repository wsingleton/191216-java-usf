package com.revature.repos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    public Optional<User> findUserByUsername(String username){
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_users WHERE ers_username = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return _user;
    }

    public Optional<User> findByCredentials(String username, String password){
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_users WHERE ers_username = ? AND ers_password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return _user;
    }

    public boolean updateRole(User updateObj) {

        boolean userRoleUpdate = false;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "UPDATE ers.ers_users SET user_role_id = ? WHERE ers_user_id =  ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, updateObj.getRole().getId());

            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0){
                userRoleUpdate = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userRoleUpdate;
    }

    @Override
    public void save(User newObj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO ers.ers_users VALUES ((SELECT MAX(ers_user_id)+1 FROM ers.ers_users),?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newObj.getUser_name());
            pstmt.setString(2, newObj.getPass_word());
            pstmt.setString(3, newObj.getFirst_name());
            pstmt.setString(4, newObj.getLast_name());
            pstmt.setString(5, newObj.getUser_email());
            pstmt.setInt(6, newObj.getRole().getId());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setUser_id(rs.getInt(1));
                }
            }
        }
        catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set findAll() {

        Set<User> users = new HashSet<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            users = mapResultSet(rs);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> _user = Optional.empty();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM ers.ers_users WHERE ers_user_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Set<User> set = mapResultSet(rs);
            if(!set.isEmpty()) _user = set.stream().findFirst();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return _user;
    }

    @Override
    public boolean update(User updateObj) {

        boolean userUpdate = false;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "UPDATE ers.ers_users SET ers_user_name = ?, ers_password = ?, " +
                         "user_first_name = ?, user_last_name = ?, user_email = ?)" +
                         "WHERE ers_user_id =  ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updateObj.getUser_name());
            pstmt.setString(2, updateObj.getPass_word());
            pstmt.setString(3, updateObj.getFirst_name());
            pstmt.setString(4, updateObj.getLast_name());
            pstmt.setString(5, updateObj.getUser_email());

            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0){
                userUpdate = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userUpdate;
    }

    @Override
    public boolean deleteById(int id) {

        boolean deleteUser = false;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "DELETE FROM ers.ers_users WHERE ers_user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();

            if(rowsDeleted > 0){
                deleteUser = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return deleteUser;
    }

    private Set<User> mapResultSet(ResultSet rs) throws SQLException{
        Set<User> users = new HashSet<>();
        while(rs.next()){
            User temp = new User();
            temp.setUser_id(rs.getInt("user_id"));
            temp.setUser_name(rs.getString("ers_username"));
            temp.setPass_word(rs.getString("ers_password"));
            temp.setFirst_name(rs.getString("user_first_name"));
            temp.setLast_name(rs.getString("user_last_name"));
            temp.setUser_email(rs.getString("user_email"));
            temp.setRole(Role.getRoleById(rs.getInt("user_role_id")));
            users.add(temp);
        }
        return users;
    }
}
